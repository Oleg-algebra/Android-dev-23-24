package com.example.shop.domain

data class ShopItem(
    var name: String,
    var count: Int,
    var id: Long = UNDEFINED,
    val isActive: Boolean = true,
) {
    companion object{
        const val UNDEFINED = -1L
    }
}