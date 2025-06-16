package com.example.osnovaprj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.osnovaprj.ui.screen.ForgotPassword.screen.ForgotPassword
import com.example.osnovaprj.ui.screen.check.CheckCode
import com.example.osnovaprj.ui.screen.registration.screen.Registration

import com.example.osnovaprj.ui.screen.signIn.screen.SignInScreen
import com.example.osnovaprj.ui.theme.MatuleTheme
import org.w3c.dom.Text
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.osnovaprj.ui.screen.Search.SearchScreen
import com.example.osnovaprj.ui.screen.popularScreen.PopularScreen
import com.example.osnovaprj.ui.screen.userScreen.MainScreen
import com.example.osnovaprj.ui.screen.userScreen.component.BottomBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

            MatuleTheme {
                Scaffold(
                    bottomBar = {
                        if (currentRoute in listOf("mainScreen", "popularScreen", "notifications", "profile")) {
                            BottomBar(navController = navController)
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "signIn",
                        modifier = Modifier.padding(padding)
                    ) {
                        composable("signIn") {
                            SignInScreen(
                                onNavigationToRegistration = {
                                    navController.navigate("registration")
                                },
                                onNavigationToForgotPassword = {
                                    navController.navigate("forgotPassword")
                                },
                                onNaviationToMainScreen = {
                                    navController.navigate("mainScreen")
                                }
                            )
                        }
                        composable("registration") {
                            Registration(
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                onNavigationToSignInScreen = {
                                    navController.navigate("signIn")
                                }
                            )
                        }
                        composable("forgotPassword") {
                            ForgotPassword(
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                onNavigationToCheckCode = {
                                    navController.navigate("checkCode")
                                }
                            )
                        }
                        composable("checkCode") {
                            CheckCode(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("mainScreen") {
                            MainScreen(
                                navController = navController,
                                onSearchClick = {
                                    navController.navigate("searchScreen")}
                            )
                        }
                        composable("searchScreen") {
                            SearchScreen(
                                onBackClick = {
                                    navController.navigate("mainScreen")
                                }
                            )
                        }
                        composable("popularScreen") {
                            PopularScreen(
                                onBackClick = { navController.popBackStack() },
                                onFavoriteClick = { /* ... */ },
                                onCartClick = { /* ... */ }
                            )
                        }
                        composable("notifications") {
                            // Add your implementation
                        }
                        composable("profile") {
                            // Add your implementation
                        }
                    }
                }
            }
        }
    }
}