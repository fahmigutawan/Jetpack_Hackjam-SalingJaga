package com.raion.myapplication.di

import com.raion.myapplication.data.AppRepository
import com.raion.myapplication.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single { AppRepository() }
}

val ViewModelModule = module {
    viewModel { MainViewModel(repository = get()) }
}
