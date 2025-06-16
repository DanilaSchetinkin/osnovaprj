package com.example.osnovaprj.ui.screen.userScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.osnovaprj.R



@Composable
fun BottomBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5))
    ) {
        Image(
            modifier = Modifier.fillMaxWidth()
                ,
            painter = painterResource(R.drawable.bottombb),
            contentDescription = "Bottom Bar",
            contentScale = ContentScale.FillWidth
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 31.dp, vertical = 52.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("mainScreen") },
                modifier = Modifier.size(24.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.home_2),
                    contentDescription = "home"
                )
            }

            IconButton(
                onClick = { navController.navigate("popularScreen") },
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = "heart"
                )
            }

            Spacer(modifier = Modifier.width(48.dp))

            IconButton(onClick = {},
                modifier = Modifier.size(24.dp)) {
                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = "bell"
                )
            }

            IconButton(onClick = {},
                modifier = Modifier.size(24.dp)) {
                Icon(
                    painter = painterResource(R.drawable.chel),
                    contentDescription = "chel"
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF48B2E7))
            ) {
                Icon(
                    painter = painterResource(R.drawable.cumka),
                    contentDescription = "korzina",
                    tint = Color.White
                )
            }
        }
    }
}