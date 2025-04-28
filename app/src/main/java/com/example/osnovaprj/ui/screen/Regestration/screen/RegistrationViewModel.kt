package com.example.osnovaprj.ui.screen.Regestration.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel(){
    var registrationInState = mutableStateOf(RegistrationInState())
        private set

    fun setEmail(email: String){
        registrationInState.value = registrationInState.value.copy(email = email)
    }
    fun setPassword(password: String){
        registrationInState.value = registrationInState.value.copy(password = password)
    }
}