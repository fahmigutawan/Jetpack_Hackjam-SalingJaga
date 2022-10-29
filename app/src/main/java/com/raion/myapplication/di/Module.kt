package com.raion.myapplication.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.raion.myapplication.data.AppRepository
import com.raion.myapplication.viewmodel.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single { FirebaseFirestore.getInstance() }
    single { FirebaseDatabase.getInstance() }
    single { FirebaseAuth.getInstance() }
    single {
        AppRepository(
            context = androidContext(),
            firestoreDb = get(),
            relatimeDb = get(),
            auth = get()
        )
    }
}

val ViewModelModule = module {
    viewModel { MainViewModel(repository = get()) }
    viewModel { SplashViewModel(repository = get()) }
    viewModel { LoginViewModel(repository = get()) }
    viewModel { RegisterViewModel(repository = get()) }
    viewModel { HomeViewModel(repository = get()) }
}
