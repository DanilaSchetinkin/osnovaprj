package com.example.osnovaprj.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun CommonButton(onClick: ()-> Unit,
                 buttonColors: ButtonColors,
                 modifier: Modifier = Modifier,
                 content:@Composable () -> Unit
                ){
    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(14.dp))
            ,
        colors = buttonColors,
        onClick = onClick
    ) {
        content()
    }
}