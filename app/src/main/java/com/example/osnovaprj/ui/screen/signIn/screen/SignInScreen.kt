package com.example.osnovaprj.ui.screen.signIn.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.screen.signIn.component.AuthButton
import com.example.osnovaprj.ui.screen.signIn.component.AuthPasswordTextField
import com.example.osnovaprj.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.osnovaprj.ui.theme.MatuleTheme
import com.example.osnovaprj.ui.screen.signIn.component.AuthTextField




@Composable
fun SignInScreen(onNavigationToRegistration: () -> Unit,
                 onNavigationToForgotPassword: () -> Unit,
                 onNaviationToMainScreen: ()-> Unit){
    val signInViewModel: SignInViewModel = viewModel()
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null)
                }
            }
        },
        bottomBar = {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 70.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                Text(text = stringResource(R.string.sign_up),
                style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.text),
                textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable (
                            onClick = onNavigationToRegistration
                        )

                )
            }
        }
    ) { paddingValues ->
        SignInContent(paddingValues, signInViewModel, onNavigationToForgotPassword, onNaviationToMainScreen)
    }

}

@Composable
fun SignInContent(
    paddingValues: PaddingValues,
    signInViewModel: SignInViewModel,
    onNavigationToForgotPassword: () -> Unit,
    onNaviationToMainScreen: () -> Unit
){
    val signInState = signInViewModel.signInState
    Column(
        modifier = Modifier.padding(paddingValues = paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp)
    )
     {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_subtitle)
        )


        Spacer(modifier = Modifier.height(35.dp))


         AuthTextField(
            value = signInState.value.email,
            onChangeValue = {
                signInViewModel.setEmail(it)
            },
            isError = signInViewModel.emailHasError.value,
            placeholder = {
                Text(text = stringResource(R.string.template_email))
            },
            supportingText = {
                Text(text = stringResource(R.string.uncorrect_email))
            },

            label = {
                Text(text =stringResource(R.string.email))
            }
        )

            AuthPasswordTextField(
                value = signInState.value.password,
                onChangeValue = {
                    signInViewModel.setPassword(it)
                },
                isError = false,
                placeholder = {
                    Text(text = stringResource(R.string.password_template))
                },
                supportingText = {
                    Text(text = stringResource(R.string.uncorrtect_password))
                },
                label = {
                    Text(text = stringResource(R.string.password))
                },


            )


            Row (
                horizontalArrangement = Arrangement.End,
                modifier = Modifier

                    .height(16.dp)
                    .fillMaxWidth()
            ) {



                Text(

                    textAlign = TextAlign.Right,
                    text = stringResource(R.string.recover),
                    style = MatuleTheme.typography.bodyRegular12.copy(color = Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 20.dp)


                        .height(16.dp)
                        .clickable(
                            onClick = onNavigationToForgotPassword
                        )
                )
            }
         AuthButton(
             onClick = onNaviationToMainScreen
         ) {
             Text(stringResource(R.string.sign_in))
         }

        }



    }











