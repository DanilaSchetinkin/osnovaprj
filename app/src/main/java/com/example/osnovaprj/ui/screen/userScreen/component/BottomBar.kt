package com.example.osnovaprj.ui.screen.userScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.osnovaprj.R


@Composable
fun BottomBar() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color.Red)
    ) {
        Image(

            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.bottombb),
            contentDescription = "Bottom Bar",
            contentScale = ContentScale.FillWidth

        )
        Image(

            contentDescription = "home",
            painter = painterResource(R.drawable.home_2)
        )
        Image(
            contentDescription = "heart",
            painter = painterResource(R.drawable.icon)
        )
    }
}