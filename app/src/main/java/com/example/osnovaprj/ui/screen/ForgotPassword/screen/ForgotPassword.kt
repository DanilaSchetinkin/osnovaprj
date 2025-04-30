package com.example.osnovaprj.ui.screen.ForgotPassword.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.screen.signIn.component.AuthButton
import com.example.osnovaprj.ui.screen.signIn.component.AuthTextField
import com.example.osnovaprj.ui.screen.signIn.component.TitleWithSubtitleText

@Composable
fun ForgotPassword(){
    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()

    Scaffold(
        topBar = {
            Row (
                modifier = Modifier
                    .padding(top = 35.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = null
                    )
                }
        }
        }
    ) { paddingValues ->
        ForgotPasswordContent(paddingValues, forgotPasswordViewModel)
    }

}


@Composable
fun ForgotPasswordContent(paddingValues: PaddingValues, forgotPasswordViewModel: ForgotPasswordViewModel){
    val forgotPasswordState = forgotPasswordViewModel.forgotPasswordState
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        TitleWithSubtitleText(
            title = "Забыл Пароль",
            subTitle = "Введите Свою Учетную Запись Для Сброса"
        )


        Spacer(modifier = Modifier.height(35.dp))


        AuthTextField(
            value = forgotPasswordState.value.email,
            onChangeValue = {
                forgotPasswordViewModel.setEmail(it)
            },
            isError = forgotPasswordViewModel.emailHasError.value,
            placeholder = {
                Text(text = stringResource(R.string.template_email))
            },
            supportingText = {
                Text(text = stringResource(R.string.uncorrect_email))
            },

            label = {
                Text(text = stringResource(R.string.email))
            }
        )

        AuthButton(onClick ={} ) {
            Text(stringResource(R.string.send))
        }

    }
}