package com.example.osnovaprj.ui.screen.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.osnovaprj.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val searchHistory = remember {
        listOf("New Shoes", "Nike Top Shoes", "Nike Air Force")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Поиск") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(contentDescription = "Стрелка",
                            painter = painterResource(R.drawable.back_arrow)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Поле поиска
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                placeholder = { Text("Поиск") },
                leadingIcon = { Icon(Icons.Default.Search, null) },
                singleLine = true
            )

            // История поиска
            if (searchHistory.isNotEmpty()) {
                Text(
                    "История поиска",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )

                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(searchHistory) { item ->
                        SearchHistoryItem(item) {
                            searchQuery = item
                            // Выполнить поиск
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchHistoryItem(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        style = MaterialTheme.typography.bodyMedium
    )
}