package app.whatrsuhik.core.foundation.core

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Monitor<T : Any?>(initValue: T) : ReadWriteProperty<Any?, T> {
    companion object {
        fun <T : Any?> monitored(initValue: T) = Monitor(initValue)
    }

    private val state: MutableState<T> = mutableStateOf(initValue)

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return state.value
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        state.value = value
    }
}