package com.example.osnovaprj.ui.screen.registration.screen

data class RegistrationState (
    var name: String ="",
    var email:String ="",
    var password:String ="",
    var isVisiblePassword: Boolean = false,
    var isLoading: Boolean = false,
    var isRegistration: Boolean = false,
    var errorMessage:String? = null
)