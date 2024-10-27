package app.whatrushik.domain.api


interface DataUseCase<D, T> {
    suspend fun execute(data: D): T
}

interface UseCase<T> {
    suspend fun execute(): T
}