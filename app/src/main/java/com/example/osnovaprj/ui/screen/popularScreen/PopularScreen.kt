package com.example.osnovaprj.ui.screen.popularScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.osnovaprj.R
import com.example.osnovaprj.ui.screen.Card.CardState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularScreen(
    onBackClick: () -> Unit,
    onFavoriteClick: (CardState) -> Unit,
    onCartClick: (CardState) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Популярное") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(R.drawable.back_arrow),
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        },
        content = { padding ->
            PopularContent(
                modifier = Modifier.padding(padding),
                onFavoriteClick = onFavoriteClick,
                onCartClick = onCartClick
            )
        }
    )
}

@Composable
private fun PopularContent(
    modifier: Modifier = Modifier,
    onFavoriteClick: (CardState) -> Unit,
    onCartClick: (CardState) -> Unit
) {
    val products = remember {
        List(6) { index ->
            CardState(
                id = index + 1,
                name = "Nike Air Max",
                price = "₽752.00",
                imageResId = R.drawable.skrpng,
                isFavorite = false,
                isInCart = false
            )
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(products) { product ->
            PopularProductCard(
                product = product,
                onFavoriteClick = { onFavoriteClick(product) },
                onCartClick = { onCartClick(product) }
            )
        }
    }
}

@Composable
private fun PopularProductCard(
    product: CardState,
    onFavoriteClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "BEST SELLER",
                color = Color(0xFF48B2E7),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Column {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = product.price,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        }
    }
}