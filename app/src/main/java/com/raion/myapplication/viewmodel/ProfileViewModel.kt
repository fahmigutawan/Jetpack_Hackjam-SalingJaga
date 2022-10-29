package com.raion.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raion.myapplication.data.AppRepository
import kotlinx.coroutines.launch

class ProfileViewModel constructor(
    private val repository: AppRepository
):ViewModel() {
    fun logout(onSuccess:() -> Unit) = viewModelScope.launch {
        repository.logout { onSuccess() }
    }
}