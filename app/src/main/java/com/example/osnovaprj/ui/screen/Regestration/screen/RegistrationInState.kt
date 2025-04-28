package com.example.osnovaprj.ui.screen.Regestration.screen

data class RegistrationInState (
    var name: String ="",
    var email:String ="",
    var password:String ="",
    var isVisiblePassword: Boolean = false,
    var isLoading: Boolean = false,
    var isRegistration: Boolean = false,
    var errorMessage:String? = null
)