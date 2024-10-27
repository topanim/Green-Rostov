package app.whatrushik.main.di

import app.whatrushik.main.children.expenses.domain.ExpensesController
import app.whatrushik.main.children.general.domain.GeneralController
import app.whatrushik.main.domain.MainScreenViewModel
import org.koin.dsl.module

val mainModule = module {
    single { MainScreenViewModel() }
    single { ExpensesController() }
    single { GeneralController(get(), get(), get()) }
}