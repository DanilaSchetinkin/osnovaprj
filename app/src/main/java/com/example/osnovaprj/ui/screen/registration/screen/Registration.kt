package com.example.osnovaprj.ui.screen.registration.screen

import android.widget.CheckBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.osnovaprj.R

import com.example.osnovaprj.ui.screen.signIn.component.AuthButton
import com.example.osnovaprj.ui.screen.signIn.component.AuthNameTextField
import com.example.osnovaprj.ui.screen.signIn.component.AuthPasswordTextField
import com.example.osnovaprj.ui.screen.signIn.component.AuthTextField
import com.example.osnovaprj.ui.screen.signIn.component.TitleWithSubtitleText
import com.example.osnovaprj.ui.theme.MatuleTheme



@Composable
fun Registration(){
    val registrationViewModel: RegistrationViewModel = viewModel()
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

            },
        bottomBar = {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .fillMaxWidth()
                    .height(40.dp)
            ){
                Text(text = stringResource(R.string.ac_join),
                    style = MatuleTheme.typography.bodyRegular16.copy(color = MatuleTheme.colors.text),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clickable(
                            onClick = {

                            }
                        )
                )
            }
        }
    ){ paddingValues ->
        RegistrationContent(paddingValues, registrationViewModel)
        }
}



    @Composable
    fun RegistrationContent(paddingValues: PaddingValues, registrationViewModel: RegistrationViewModel) {
        val registrationState = registrationViewModel.registrationState
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            TitleWithSubtitleText(
                title = stringResource(R.string.Registration),
                subTitle = stringResource(R.string.sign_in_subtitle)
            )


            Spacer(modifier = Modifier.height(35.dp))



            AuthNameTextField(
                value = registrationState.value.name,
                onChangeValue = {
                    registrationViewModel.setName(it)
                },
                isError = false,
                placeholder = {
                    Text(text = stringResource(R.string.xxxxxxxx))
                },
                supportingText = {
                    Text(text = stringResource(R.string.error_name))
                },
                label = {
                    Text(text = stringResource(R.string.name))
                }
            )



            AuthTextField(
                value = registrationState.value.email,
                onChangeValue = {
                    registrationViewModel.setEmail(it)
                },
                isError = registrationViewModel.emailHasError.value,
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
            AuthPasswordTextField(
                value = registrationState.value.password,
                onChangeValue = {
                    registrationViewModel.setPassword(it)
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
                }
            )

            val isChecked = remember { mutableStateOf(false) }
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)

            ) {
                Checkbox(

                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(
                        checkedColor = MatuleTheme.colors.accent
                    )

                )
                Text(
                    style = MatuleTheme.typography.bodyRegular16.copy(color = Color.Gray),
                    textDecoration = TextDecoration.Underline,
                    text = stringResource(R.string.soglasie),
                    modifier = Modifier
                        .clickable(
                            onClick = {}
                        )


                )
            }


            AuthButton(onClick ={} ) {
                Text(stringResource(R.string.Registration_button))
            }
        }
    }


