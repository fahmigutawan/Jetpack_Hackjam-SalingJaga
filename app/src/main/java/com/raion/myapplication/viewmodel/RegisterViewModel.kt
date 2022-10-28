package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class RegisterViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    val fullNameValueState = mutableStateOf("")
    val emailValueState =  mutableStateOf("")
    val phoneNumberValueState =  mutableStateOf("")
    val addressValueState =  mutableStateOf("")
    val passwordValueState = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val showErrorSnackbar = mutableStateOf(false)
}