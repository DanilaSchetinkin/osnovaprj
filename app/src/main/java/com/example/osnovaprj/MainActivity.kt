package com.example.osnovaprj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.osnovaprj.ui.screen.registration.screen.Registration
import com.example.osnovaprj.ui.screen.signIn.screen.SignInScreen
import com.example.osnovaprj.ui.theme.MatuleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatuleTheme {
                Registration()
            }
        }
    }
}