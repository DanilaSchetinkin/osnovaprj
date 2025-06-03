package com.example.osnovaprj.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.osnovaprj.R

@Preview
@Composable
fun MainScreen() {
    var selectedCategory = remember { mutableStateOf("Все") }
    val backgroundColor = Color(0xFFF5F5F5)

    Scaffold(
        modifier = Modifier.background(backgroundColor),
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 35.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.tripalka),
                        contentDescription = "Меню"
                    )
                }

                Text(
                    text = stringResource(R.string.Glavnaya),
                    fontSize = 32.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_mono_semibold)),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.cumka),
                        contentDescription = "Поиск"
                    )
                }
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.background(backgroundColor)
            ) {
                Image(
                    painter = painterResource(R.drawable.bottombb),
                    contentDescription = "Bottom Bar"
                )
            }
        },
        content = { innerPadding ->
            // Основное содержимое экрана
            MainScreenContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(backgroundColor)
            )
        }
    )
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier) {
    // Здесь должно быть основное содержимое вашего экрана
    // Например:
    Text(
        text = "Основное содержимое экрана",
        modifier = modifier
    )
}

@Composable
fun TopAppBar() {
    // Реализация вашего TopAppBar, если она нужна отдельно
}