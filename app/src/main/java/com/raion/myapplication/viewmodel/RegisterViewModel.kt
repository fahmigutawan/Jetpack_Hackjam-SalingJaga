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
    val showShouldFillAllFields = mutableStateOf(false)
    val startRegisterFlow = mutableStateOf(false)

    fun registerWithEmailPassword(onSuccess: () -> Unit, onFailed: () -> Unit) =
        repository.registerWithEmailPassword(
            email = emailValueState.value,
            password = passwordValueState.value,
            onSuccess = onSuccess,
            onFailed = onFailed
        )

    fun allFilled():Boolean{
        if(emailValueState.value.isEmpty()) return false
        if(passwordValueState.value.isEmpty()) return false
        if(fullNameValueState.value.isEmpty()) return false
        if(phoneNumberValueState.value.isEmpty()) return false
        if(addressValueState.value.isEmpty()) return false
        return true
    }
}