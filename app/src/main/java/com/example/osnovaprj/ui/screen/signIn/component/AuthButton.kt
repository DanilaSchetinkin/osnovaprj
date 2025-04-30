package com.example.osnovaprj.ui.screen.signIn.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.ui.common.CommonButton
import com.example.osnovaprj.ui.theme.MatuleTheme


@Composable
fun AuthButton(
    onClick: ()-> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
){
    CommonButton(
        onClick = onClick,
        buttonColors = ButtonColors(
            contentColor = MatuleTheme.colors.background,
            containerColor = MatuleTheme.colors.accent,
            disabledContentColor = MatuleTheme.colors.accent,
            disabledContainerColor = MatuleTheme.colors.accent
            ),
        modifier = modifier.padding(top = 30.dp),
    ){
        content()
    }
}