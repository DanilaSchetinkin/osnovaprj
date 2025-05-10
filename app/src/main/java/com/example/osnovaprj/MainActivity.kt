package com.example.osnovaprj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.osnovaprj.ui.screen.ForgotPassword.screen.ForgotPassword
import com.example.osnovaprj.ui.screen.check.CheckCode
import com.example.osnovaprj.ui.screen.registration.screen.Registration
import com.example.osnovaprj.ui.screen.signIn.screen.One
import com.example.osnovaprj.ui.screen.signIn.screen.SignInScreen
import com.example.osnovaprj.ui.theme.MatuleTheme
import org.w3c.dom.Text
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MatuleTheme {
                NavHost(
                    navController = navController,
                    startDestination = "signIn"
                ) {
                    // Здесь будут определены все маршруты
                    composable("signIn") {


                        SignInScreen(
                            onNavigationToRegistration = {
                                navController.navigate("registration")
                            },
                            onNavigationToForgotPassword = {
                                navController.navigate("forgotPassword")
                            }
                        )
                    }
                    composable("registration") {
                        Registration(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("forgotPassword") {
                        ForgotPassword(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    /*composable("checkCode") {
                        CheckCode(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }*/
                }
            }
        }
    }
}