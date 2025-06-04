package com.example.osnovaprj.ui.screen

import androidx.compose.runtime.Composable


@Composable
fun BottomNavBar(selectedItem:Int,onItemSelected:(Int)-> Unit)
{
   /* import androidx.compose.foundation.background
            import androidx.compose.foundation.clickable
            import androidx.compose.foundation.layout.*
            import androidx.compose.material3.*
            import androidx.compose.runtime.*
            import androidx.compose.ui.Alignment
            import androidx.compose.ui.Modifier
            import androidx.compose.ui.graphics.Color
            import androidx.compose.ui.res.painterResource
            import androidx.compose.ui.unit.dp
            import com.example.osnovaprj.R

            @Composable
            fun BottomNavBar(selectedItem: Int, onItemSelected: (Int) -> Unit) {
                val items = listOf(
                    R.drawable.home to "Home",
                    R.drawable.heart to "Favorite",
                    R.drawable.cart to "Cart",
                    R.drawable.bell to "Notifications",
                    R.drawable.profile to "Profile"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items.forEachIndexed { index, item ->
                        IconButton(
                            onClick = { onItemSelected(index) },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = item.first),
                                contentDescription = item.second,
                                tint = if (index == selectedItem) Color(0xFF2FA4FF) else Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }*/
}
/*
val selectedIndex = remember { mutableStateOf(2) } // Cart выбран по умолчанию

Scaffold(
bottomBar = {
    BottomNavBar(selectedItem = selectedIndex.value) {
        selectedIndex.value = it
    }
},
// ...
)*/
