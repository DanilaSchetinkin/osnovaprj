package com.example.osnovaprj.ui.screen.registration.screen

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel(){
    var registrationState = mutableStateOf(RegistrationState())
        private set


    val emailHasError = derivedStateOf {
        if (registrationState.value.email.isEmpty()) return@derivedStateOf  false
        !android.util.Patterns.EMAIL_ADDRESS.matcher(registrationState.value.email).matches()
    }

    fun setName(name: String){
        registrationState.value = registrationState.value.copy(name = name)
    }

    fun setEmail(email: String){
        registrationState.value = registrationState.value.copy(email = email)
    }
    fun setPassword(password: String){
        registrationState.value = registrationState.value.copy(password = password)
    }
}