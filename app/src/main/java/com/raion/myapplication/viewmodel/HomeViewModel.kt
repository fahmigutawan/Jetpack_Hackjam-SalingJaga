package com.raion.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class HomeViewModel constructor(
    private val repository: AppRepository
):ViewModel() {
}