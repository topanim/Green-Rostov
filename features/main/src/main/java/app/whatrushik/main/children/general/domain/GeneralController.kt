package app.whatrushik.main.children.general.domain

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.whatrsuhik.core.foundation.core.UIController
import app.whatrsuhik.core.foundation.utils.safeExecute
import app.whatrsuhik.core.foundation.utils.suspendCall
import app.whatrushik.api_sdk.api.ecology.IEcologyService
import app.whatrushik.api_sdk.api.patrol.IPatrolService
import app.whatrushik.api_sdk.shared.dto.Ecology
import app.whatrushik.api_sdk.shared.dto.Event
import app.whatrushik.api_sdk.shared.dto.Patrol
import app.whatrushik.domain.impl.getEvents.IGetEventsUseCase
import app.whatrushik.main.children.general.domain.models.GeneralAction
import app.whatrushik.main.children.general.domain.models.GeneralEvent
import app.whatrushik.main.children.general.domain.models.GeneralState
import app.whatrushik.main.children.general.domain.models.Loading
import com.yandex.mapkit.geometry.Point
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class GeneralController(
    private val getEventsUseCase: IGetEventsUseCase,
    private val patrolService: IPatrolService,
    private val ecologyService: IEcologyService
) : UIController<GeneralState, GeneralAction, GeneralEvent>(
    GeneralState()
) {
    override fun obtainEvent(viewEvent: GeneralEvent) = when (viewEvent) {
        GeneralEvent.Init -> init()
        is GeneralEvent.SearchField -> {}
        is GeneralEvent.OnSelectFilter -> selectFilter(viewEvent.index)
        is GeneralEvent.OnMarkClicked -> onMarkClicked(viewEvent.point)
        is GeneralEvent.OnSelectCategory -> onSelectCategory(viewEvent.index)

        is GeneralEvent.OnEventClicked ->
            setAction(
                GeneralAction.NavigateToEventDetail(
                    viewEvent.id,
                    viewEvent.title,
                    viewEvent.description,
                    viewEvent.picture,
                    viewEvent.latitude,
                    viewEvent.longitude
                )
            )

        GeneralEvent.OnClearSelection -> updateState { copy(selectedEventIndex = null) }
        is GeneralEvent.OnPatrolParticipate -> participatePatrol()
    }

    private fun init() {
        fetchEvent()
        fetchPatrols()
        fetchUvInfo()
    }

    private fun fetchUvInfo() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val uvResponse = ecologyService.getUV(Ecology.Parameters.Get())
                safeUpdateState { copy(uvIndex = uvResponse.value) }
            }
        ) {
            Log.d("d", "Error: $it")
        }
    }

    private fun participatePatrol() {
        updateState { copy(passingPatrol = true) }

        safeExecute(
            scope = viewModelScope,
            block = {
                val patrol = viewState.patrols[viewState.selectedPatrolIndex!!]
                patrolService.pass(
                    Patrol.Parameters.Pass(
                        patrol.id,
                        "Все в порядке"
                    )
                )

                Log.d("d", "patrol: $patrol")

                delay(700L)
                val patrolResponse = patrolService.me(Patrol.Parameters.Me())

                safeUpdateState {
                    copy(
                        patrols = patrolResponse,
                        points = patrolResponse.patrolToPointsList()
                    )
                }

                safeUpdateState { copy(passingPatrol = false) }
            }
        ) {
            Log.d("d", "Error: $it")
        }
    }

    private fun List<Patrol.Responses.Patrol>.patrolToPointsList(): List<Point> =
        filter { it.answers.isEmpty() }.map { Point(it.xPos, it.yPos) }

    private fun List<Event.Responses.Event>.eventToPointsList(): List<Point> =
        map { Point(it.latitude, it.longitude) }

    private fun fetchPatrols() {
        safeExecute(
            block = {
                val patrolResponse = patrolService.me(Patrol.Parameters.Me())

                safeUpdateState {
                    copy(
                        patrols = patrolResponse,
                        points = patrolResponse.patrolToPointsList()
                    )
                }
            }
        ) {
            Log.d("d", "Error: $it")
        }
    }

    private fun onSelectCategory(index: Int) {
        val shownPoints = when (index) {
            0 -> viewState.patrols.patrolToPointsList()
            1 -> viewState.events.eventToPointsList()
            else -> emptyList()
        }

        updateState {
            copy(selectedCategoryIndex = index, points = shownPoints)
        }

        Log.d("d", "viewState: $viewState")
    }

    private fun onMarkClicked(point: Point) {
        suspendCall(IO, viewModelScope) {
            val closestEventIndex = when (viewState.selectedCategoryIndex) {
                0 -> findClosestOneIndex(point, viewState.patrols.patrolToPointsList())
                1 -> findClosestOneIndex(point, viewState.events.eventToPointsList())
                else -> null
            }

            safeUpdateState {
                when (viewState.selectedCategoryIndex) {
                    0 -> copy(
                        selectedPatrolIndex = closestEventIndex,
                        selectedEventIndex = null
                    )

                    1 -> copy(
                        selectedEventIndex = closestEventIndex,
                        selectedPatrolIndex = null
                    )

                    else -> this
                }
            }
        }
    }

    private fun selectFilter(index: Int) {
        updateState { copy(selectedFilterIndex = index) }
    }

    private fun fetchEvent() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val request = getEventsUseCase.execute()
                updateState {
                    copy(
                        events = request,
                        marksLoadingState = Loading.IsLoaded
                    )
                }
            }
        )
    }

    private fun findClosestOneIndex(
        target: Point,
        coordinates: List<Point>
    ): Int {
        var closestCoordinate = coordinates[0]
        var closestCoordinateIndex = 0
        var minDistance = distance(target, closestCoordinate)

        coordinates.forEachIndexed { index, coordinate ->
            val currentDistance = distance(target, coordinate)
            if (currentDistance < minDistance) {
                minDistance = currentDistance
                closestCoordinate = coordinate
                closestCoordinateIndex = index
            }
        }

        return closestCoordinateIndex
    }

    private fun distance(p1: Point, p2: Point): Double {
        val earthRadius = 6371 // Радиус Земли в километрах

        val lat1Rad = Math.toRadians(p1.latitude)
        val lon1Rad = Math.toRadians(p1.longitude)
        val lat2Rad = Math.toRadians(p2.latitude)
        val lon2Rad = Math.toRadians(p2.longitude)

        val dLat = lat2Rad - lat1Rad
        val dLon = lon2Rad - lon1Rad

        val a = sin(dLat / 2).pow(2) + cos(lat1Rad) * cos(lat2Rad) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return earthRadius * c
    }
}
