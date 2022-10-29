package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class MyProfileViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    val fullNameValueState = mutableStateOf("")
    val emailValueState =  mutableStateOf("")
    val phoneNumberValueState =  mutableStateOf("")
    val provinceValueState =  mutableStateOf("")
    val cityValueState =  mutableStateOf("")
    val streetValueState =  mutableStateOf("")
    val showErrorSnackbar = mutableStateOf(false)
    val showShouldFillAllFields = mutableStateOf(false)
    val startRegisterFlow = mutableStateOf(false)



    fun allFilled():Boolean{
        if(emailValueState.value.isEmpty()) return false
        if(fullNameValueState.value.isEmpty()) return false
        if(phoneNumberValueState.value.isEmpty()) return false
        if(streetValueState.value.isEmpty()) return false
        return true
    }
}