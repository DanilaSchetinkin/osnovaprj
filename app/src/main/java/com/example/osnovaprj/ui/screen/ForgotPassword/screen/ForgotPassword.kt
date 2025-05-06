package com.example.osnovaprj.ui.screen.ForgotPassword.screen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.screen.signIn.component.AuthButton
import com.example.osnovaprj.ui.screen.signIn.component.AuthTextField
import com.example.osnovaprj.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.osnovaprj.ui.theme.MatuleTheme
import kotlinx.coroutines.delay

@Composable
fun ForgotPassword(){
    val forgotPasswordViewModel: ForgotPasswordViewModel = viewModel()
    val showEmailSentDialog = remember { mutableStateOf(false) }

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
        ForgotPasswordContent(paddingValues,
            forgotPasswordViewModel,
            onEmailSent = {showEmailSentDialog.value = true}
        )
        if (showEmailSentDialog.value){
            EmailSentDialog(onDismiss = { showEmailSentDialog.value = false})
        }
    }

}

@Composable
fun EmailSentDialog(
    onDismiss:() -> Unit
) {
    LaunchedEffect(Unit) {
        delay(3000L)
        onDismiss()
    }
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},

        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {


                Box(modifier = Modifier.size(44.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_674__1_),
                        contentDescription = stringResource(R.string.fon),
                        modifier = Modifier.fillMaxSize()

                    )
                    Image(
                        painter = painterResource(id = R.drawable.email_1),
                        contentDescription = stringResource(R.string.email_icon),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = stringResource(R.string.check_your_email),
                        textAlign = TextAlign.Center,
                        style = MatuleTheme.typography.bodyRegular16,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.send_code),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

            }
        }


        )
}

@Composable
fun ForgotPasswordContent(paddingValues: PaddingValues,
                          forgotPasswordViewModel: ForgotPasswordViewModel,
                          onEmailSent:() -> Unit){
    val forgotPasswordState = forgotPasswordViewModel.forgotPasswordState
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        TitleWithSubtitleText(
            title = stringResource(R.string.forgot_password),
            subTitle = stringResource(R.string.input_account)
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


        AuthButton(onClick = {
            if (!forgotPasswordViewModel.emailHasError.value){
                onEmailSent()
            }
        }
        ) {
            Text(stringResource(R.string.send))
        }


    }
}