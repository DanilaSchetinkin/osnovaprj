package com.example.osnovaprj.ui.screen.userScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.screen.userScreen.component.BottomBar
import com.example.osnovaprj.ui.theme.MatuleTheme


@Preview
@Composable
fun MainScreen() {
    var selectedCategory = remember { mutableStateOf("Все") }
   /* val backgroundColor = Color(0xFFF5F5F5)*/

    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            ,
        topBar = {

            Row(
                modifier = Modifier
                    .padding(top = 35.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()

                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(24.dp)
                ) {
                    Image(
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

           BottomBar()
        },
        content = { innerPadding ->

            MainScreenContent(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()

            )
        }
    )
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF5F5F5))
    )
            {
                // Search Row
                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("Поиск") },
                        leadingIcon = {
                            Image(
                                painter = painterResource(R.drawable.lupa),
                                contentDescription = "Поиск"
                            )
                        },
                        shape = RoundedCornerShape(12.dp),

                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                    IconButton(
                        modifier = Modifier.height(52.dp)
                            .width(52.dp),
                        onClick = {}) {
                        Image(
                            modifier = Modifier,
                            contentDescription = "nastroyka",
                            painter = painterResource(R.drawable.nastroyka)
                        )
                    }
                }

                // Main content goes here
                Text(

                    text = "Категории",
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 8.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_serif)), // Убедитесь что у вас есть этот шрифт
                    color = Color.Black
                )
            }
}