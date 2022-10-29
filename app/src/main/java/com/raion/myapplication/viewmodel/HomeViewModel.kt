package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class HomeViewModel constructor(
    private val repository: AppRepository
):ViewModel() {
    val showLocationPermissionDeniedRationale = mutableStateOf(false)
    val showLocationPermissionDeniedNotRationale = mutableStateOf(false)
}