package com.example.osnovaprj.ui.screen.check

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.osnovaprj.R

import com.example.osnovaprj.ui.screen.registration.screen.RegistrationViewModel
import com.example.osnovaprj.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.osnovaprj.ui.theme.MatuleTheme

@Composable
fun CheckCode() {
    val checkCodeViewModel: CheckCodeViewModel = viewModel()

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
    ){paddingValues -> CheckCodeContent(paddingValues, checkCodeViewModel)  }

}


@Composable
fun CheckCodeContent(paddingValues: PaddingValues, checkCodeViewModel: CheckCodeViewModel) {
    val checkCodeState = checkCodeViewModel.checkCodeState
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        TitleWithSubtitleText(
            title = "OTP Проверка",
            subTitle = stringResource(R.string.plscheckmail)
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            text = "OTP Код",
            style = MatuleTheme.typography.bodyRegular16,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp),
            color = Color.White
        ) {
            var otpValue by remember {
                mutableStateOf("")
            }

            OtpTextField(
                otpText = otpValue,
                onOtpTextChange = { value, otpInputFilled ->
                    otpValue = value


                }
            )
        }
    }
}
