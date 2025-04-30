package com.example.osnovaprj.ui.screen.ForgotPassword.screen

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.osnovaprj.ui.screen.registration.screen.RegistrationState

class ForgotPasswordViewModel: ViewModel() {
    var forgotPasswordState = mutableStateOf(ForgotPasswordState())
        private set

    val emailHasError = derivedStateOf {
        if (forgotPasswordState.value.email.isEmpty()) return@derivedStateOf  false
        !android.util.Patterns.EMAIL_ADDRESS.matcher(forgotPasswordState.value.email).matches()
    }


    fun setEmail(email: String){
        forgotPasswordState.value = forgotPasswordState.value.copy(email = email)
    }

}