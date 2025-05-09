package com.example.osnovaprj.ui.screen.check


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.ui.theme.MatuleTheme
import kotlinx.coroutines.delay

@Composable
fun ButtonTime(){
    var countdown by remember { mutableIntStateOf(30) }
    var active by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = active, key2 = countdown,) {
        if (active && countdown > 0){
            delay(1000L)
            countdown--
        }else if (countdown == 0){
            active = false
        }

    }

    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            modifier = Modifier.clickable {
                if (!active) {
                    countdown = 30
                    active = true
                }
            },
            text = "Отправить заново",
            style = MatuleTheme.typography.bodyRegular16
        )
        if (active) {
            Text(
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                text = String.format("%02d:%02d", countdown / 60, countdown % 60),
                style = MatuleTheme.typography.bodyRegular16,

                )
        }
    }

}