package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class LoginViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    val emailValueState =  mutableStateOf("")
    val passwordValueState = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val showErrorSnackbar = mutableStateOf(false)
}