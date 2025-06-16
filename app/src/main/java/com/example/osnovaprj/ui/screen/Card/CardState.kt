package com.example.osnovaprj.ui.screen.Card

data class CardState(
    val id: Int,
    val name: String,
    val price: String,
    val imageResId: Int,
    var isFavorite: Boolean = false,
    var isInCart: Boolean = false
)