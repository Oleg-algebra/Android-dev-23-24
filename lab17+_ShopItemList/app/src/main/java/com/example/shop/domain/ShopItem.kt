package com.example.shop.domain

data class ShopItem(
    val name: String,
    val count: Int,
    val id: Long = UNDEFINED,
    val isActive: Boolean = true,
) {
    companion object{
        private const val UNDEFINED = -1L
    }
}