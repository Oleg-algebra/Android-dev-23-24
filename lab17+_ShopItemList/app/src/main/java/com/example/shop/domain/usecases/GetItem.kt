package com.example.shop.domain.usecases

import com.example.shop.domain.ShopItemRepository

class GetItem(
    private val repository: ShopItemRepository
) {
    fun getItem(id: Long) = repository.getShopItem(id)
}