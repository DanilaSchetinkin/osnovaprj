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
import com.example.osnovaprj.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Preview
@Composable
fun BottomBar() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFFF5F5F5))
    ) {


        Image(

            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.bottombb),
            contentDescription = "Bottom Bar",
            contentScale = ContentScale.FillWidth


        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 31.dp, vertical = 52.dp)


                ){



            Image(

                contentDescription = "home",
                painter = painterResource(R.drawable.home_2),
                modifier = Modifier
                    .clickable {  }
            )
            IconButton(
                onClick = {}
            ) {
                Icon(contentDescription = "heart",
                    painter = painterResource(R.drawable.icon))
            }


            Spacer(modifier = Modifier.width(56.dp))


            IconButton(
                onClick = {}

            )
            {
                Icon(painter = painterResource(R.drawable.bell),
                    contentDescription = "bell",
                    )
            }




            IconButton(
                onClick = {}
            ) {
                Icon(contentDescription = "chel",
                    painter = painterResource(R.drawable.chel),)

            }



        }

        Box(

            Modifier.fillMaxWidth()
                .align(Alignment.TopCenter)
                .offset(y = (+5).dp)
                ,
            contentAlignment = Alignment.Center


        )
        {
            IconButton(onClick ={},
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF48B2E7))
                ) {
                Icon(contentDescription = "korzina",
                    tint = Color.White ,
                   painter =  painterResource(R.drawable.cumka)
                )
            }
        }
    }
}