package com.example.osnovaprj.ui.screen.userScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.osnovaprj.ui.screen.Card.CardState
import com.example.osnovaprj.ui.screen.Card.KrossovokCard
import com.example.osnovaprj.ui.screen.userScreen.component.BottomBar
import com.example.osnovaprj.ui.theme.MatuleTheme
import com.google.android.gms.analytics.ecommerce.Product


@Composable
fun MainScreen(
    onSearchClick: () -> Unit
) {
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
                    .fillMaxSize(),
                onSearchClick = onSearchClick
            )
        }
    )
}

@Composable
fun MainScreenContent(modifier: Modifier = Modifier,
                      onSearchClick: () -> Unit) {
    val categories = listOf("Все", "Outdoor", "Tennis")
    val selectedCategory = remember { mutableStateOf("Все") }
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF5F5F5))
    )
    {

        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onSearchClick() }
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
                    ),
                    enabled = false
                )
            }
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


        Text(

            text = "Категории",
            modifier = Modifier
                .padding(start = 16.dp, bottom = 8.dp)
                .fillMaxWidth(),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.roboto_serif)), // Убедитесь что у вас есть этот шрифт
            color = Color.Black
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                CategoryItem(
                    text = category,
                    isSelected = category == selectedCategory.value,
                    onClick = { selectedCategory.value = category }
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(15.dp,)
        )
        {
            Text(

                text = "Популярное",
                modifier = Modifier.padding(start = 6.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_serif))
            )
        }
        ProductList()
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 5.dp)) {
            Text(text = "Акции",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_serif)))
        }
        Box(modifier = Modifier.fillMaxWidth()
            ) {

            Image(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp),
                contentDescription = "podgon",
                painter = painterResource(R.drawable.skrskrjpeg)
            )
        }
    }
}
@Composable
fun CategoryItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = if (isSelected) Color(0xFF48B2E7) else Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 26.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.roboto_serif))
        )
    }
}
@Composable
fun ProductList(){
    val productList = remember {
        mutableListOf(
            CardState(
                1,
                "Nike Air Max",
                "₽752.00",
                R.drawable.skrpng,
                isFavorite = true,
                isInCart = false
            ),
            CardState(
                2,
                "Nike Air Max",
                "₽752.00",
                R.drawable.skrpng,
                isFavorite = true,
                isInCart = true
            ),
            CardState(
                3,
                "Nike Air Max",
                "₽752.00",
                R.drawable.skrpng,
                isFavorite = false,
                isInCart = false
            ),
            CardState(
                4,
                "Nike Air Max",
                "₽752.00",
                R.drawable.skrpng,
                isFavorite = true,
                isInCart = false
            ),
            CardState(
                5,
                "Nike Air Max",
                "₽752.00",
                R.drawable.skrpng,
                isFavorite = false,
                isInCart = true
            )
        )
    }
    LazyRow(
        modifier =  Modifier
            .padding(start = 6.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
       items(productList.size){index ->
           val  product = productList[index]
           KrossovokCard(
               cardState = product,
               onFavoriteClick = {
                   productList[index] = product.copy(isFavorite = !product.isFavorite)
               },
               onCartClick = {
                   productList[index] = product.copy(isInCart = !product.isInCart)
               }
           )
        }
    }
}
