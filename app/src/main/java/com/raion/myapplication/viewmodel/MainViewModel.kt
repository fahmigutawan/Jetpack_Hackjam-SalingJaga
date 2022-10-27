package com.raion.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class MainViewModel(
    private val repository: AppRepository
):ViewModel() {
}