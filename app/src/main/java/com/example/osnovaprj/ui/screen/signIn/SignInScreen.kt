package com.example.osnovaprj.ui.screen.signIn

import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.theme.MatuleTheme

@Composable
fun SignInScreen(){
    SignInContent()
}

@Composable
fun SignInContent(){
    Column {
        TitleWithSubtitleText(
            title = stringResource(R.string.hello),
            subTitle = stringResource(R.string.sign_in_subtitle)
        )
    }
}

@Preview
@Composable
fun TitleWithSubtitleText(title: String, subTitle: String){
    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text(
            text = title,
            style = MatuleTheme.typography.headingBold32.copy(color = MatuleTheme.colors.text),
            textAlign = TextAlign.Center
        )
        Text(
            text = subTitle,
            maxLines = 2,
            style = MatuleTheme.typography.subTitleRegular16.copy(color = MatuleTheme.colors.subTextDark),
            textAlign = TextAlign.Center
        )
    }

}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextFiled(){
    val value = remember { mutableStateOf("") }
    val  interaction = remember { MutableInteractionSource() }
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        }
    ){innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = value.value,
            singleLine = true,
            innerTextField = innerTextField,
            enabled = true,
            visualTransformation = VisualTransformation.None,
            interactionSource = interaction
        )

    }
}