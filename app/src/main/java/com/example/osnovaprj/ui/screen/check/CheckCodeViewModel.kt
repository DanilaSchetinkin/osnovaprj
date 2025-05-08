package com.example.osnovaprj.ui.screen.check

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CheckCodeViewModel: ViewModel() {
    var checkCodeState = mutableStateOf(CheckCodeState())
        private set

    val codeHasError = derivedStateOf {
        checkCodeState.value.code.isNotEmpty()&&
                !checkCodeState.value.code.matches(Regex("^[0-9]+\$"))
    }

    fun setCode(code: String){
        checkCodeState.value = checkCodeState.value.copy(code = code)
    }

}