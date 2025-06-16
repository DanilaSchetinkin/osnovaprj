package com.example.osnovaprj.ui.screen.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.osnovaprj.R

@Composable
fun KrossovokCard(
    cardState: CardState,
    onFavoriteClick: (CardState) -> Unit,
    onCartClick: (CardState) -> Unit
) {
    Card(
        modifier = Modifier
            .width(180.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.height(120.dp)) {
                Image(
                    painter = painterResource(cardState.imageResId),
                    contentDescription = cardState.name,
                    modifier = Modifier
                        .size(120.dp),
                    contentScale = ContentScale.Fit
                )

                IconButton(
                    onClick = { onFavoriteClick(cardState) },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(4.dp)
                        .size(24.dp)
                ) {
                    Image(
                        painter = painterResource(
                            if (cardState.isFavorite) R.drawable.redheart else R.drawable.icon
                        ),
                        contentDescription = "Favorite",

                    )
                }

                IconButton(
                    onClick = { onCartClick(cardState) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(4.dp)
                        .size(24.dp)
                ) {
                    Image(
                        painter = painterResource(
                            if (cardState.isInCart) R.drawable.korzina else R.drawable.plus
                        ),
                        contentDescription = "Cart",

                    )
                }
            }

            Text(
                text = "BEST SELLER",
                color = Color.Blue,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = cardState.name,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp),
                textAlign = TextAlign.Center
            )

            Text(
                text = cardState.price,
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}