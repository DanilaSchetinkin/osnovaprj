package com.example.osnovaprj.ui.screen.signIn.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.common.CommonTextField


@Composable
fun AuthTextField(
    value: String,
    onChangeValue:(String)-> Unit,
    isError: Boolean,
    supportingText: @Composable () -> Unit,
    placeholder: @Composable ()  -> Unit,
    label: @Composable () -> Unit
){
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            label()
            CommonTextField(
                value = value,
                onChangeValue = onChangeValue,
                isError = isError,
                supportingText = supportingText,
                placeholder = placeholder
            )
        }
}




//NEW
@Composable
fun AuthPasswordTextField(
    value: String,
    onChangeValue:(String)-> Unit,
    isError: Boolean,
    supportingText: @Composable () -> Unit,
    placeholder: @Composable ()  -> Unit,
    label: @Composable () -> Unit,
){
    var passwordVisible = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        label()
        CommonTextField(
            value = value,
            onChangeValue = onChangeValue,
            isError = isError,
            supportingText = supportingText,
            placeholder = placeholder,
            trailingIcon = {
                IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                    Icon(
                        painter = painterResource(R.drawable.eye),
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if
                    (passwordVisible.value) VisualTransformation.None
            else
                PasswordVisualTransformation()


        )
    }
}



@Composable
fun AuthNameTextField(
    value: String,
    onChangeValue: (String) -> Unit,
    isError: Boolean,
    supportingText:@Composable () -> Unit,
    placeholder:@Composable () -> Unit,
    label:@Composable () -> Unit
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){

        label()
        CommonTextField(
            value = value,
            onChangeValue = onChangeValue,
            isError = isError,
            supportingText = supportingText,
            placeholder = placeholder
        )
    }
}
