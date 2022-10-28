package com.raion.myapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class MainViewModel constructor(
    private val repository: AppRepository
):ViewModel() {
    var showBottomBar by mutableStateOf(false)
    var recentBottomBarRoute by mutableStateOf("")
}