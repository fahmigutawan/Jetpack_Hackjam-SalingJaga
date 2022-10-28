package com.raion.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class SplashViewModel constructor(
    private val repository: AppRepository
):ViewModel() {
    fun userLoggedIn() = repository.userLoggedIn()
}