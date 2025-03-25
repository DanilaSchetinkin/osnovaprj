package com.example.osnovaprj.ui.screen.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.ui.theme.MatuleTheme

@Composable
fun SignInScreen(){

}

@Composable
fun SignInContent(){

}

@Preview
@Composable
fun TitleWithSubtitleText(){
    Column(

        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally  ,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(text = "123")


        HorizontalDivider(modifier =  Modifier.width(100.dp))
        Text(text = "!2222222")

    }

}