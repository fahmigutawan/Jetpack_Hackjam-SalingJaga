package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class LoginViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    val emailValueState = mutableStateOf("")
    val passwordValueState = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val showErrorSnackbar = mutableStateOf(false)
    val showFillAllFieldsSnackbar = mutableStateOf(false)
    val startLoginFlow = mutableStateOf(false)

    fun loginWithEmailPassword(onSuccess: () -> Unit, onFailed: () -> Unit) =
        repository.loginWithEmailPassword(
            email = emailValueState.value,
            password = passwordValueState.value,
            onSuccess = onSuccess,
            onFailed = onFailed
        )

    fun allFilled():Boolean{
        if(emailValueState.value.isEmpty()) return false
        if(passwordValueState.value.isEmpty()) return false
        return true
    }
}