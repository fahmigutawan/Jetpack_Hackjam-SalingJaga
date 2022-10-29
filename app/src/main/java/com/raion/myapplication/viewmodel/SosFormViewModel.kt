package com.raion.myapplication.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.raion.myapplication.data.AppRepository

class SosFormViewModel constructor(
    private val repository: AppRepository
) : ViewModel() {
    val pelaporValueState = mutableStateOf("")
    val pesanValueState = mutableStateOf("")
    val pihakRugiValueState =  mutableStateOf("")
    val tanggalValueState =  mutableStateOf("")
    val waktuValueState =  mutableStateOf("")
    val keteranganValueState =  mutableStateOf("")


    fun allFilled():Boolean{
        if(pesanValueState.value.isEmpty()) return false
        if(pihakRugiValueState.value.isEmpty()) return false
        return true
    }
}