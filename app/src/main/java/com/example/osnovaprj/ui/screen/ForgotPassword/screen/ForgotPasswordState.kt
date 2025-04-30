package com.example.osnovaprj.ui.screen.ForgotPassword.screen

data class ForgotPasswordState(
    var email:String ="",
    var isLoading: Boolean = false,
    var isRegistration: Boolean = false,
    var errorMessage:String? = null
)