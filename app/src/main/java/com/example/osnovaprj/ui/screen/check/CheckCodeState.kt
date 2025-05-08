package com.example.osnovaprj.ui.screen.check

data class CheckCodeState(
    var code:String = "",
    var isLoading: Boolean = false,
    var errorMessage:String? = null
)