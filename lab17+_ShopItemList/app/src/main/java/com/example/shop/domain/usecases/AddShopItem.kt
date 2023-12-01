package com.example.shop.domain.usecases

import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository

class AddShopItem(
    val repository: ShopItemRepository
) {
    fun addShopItem(item: ShopItem){
        repository.addShopItem(item)
    }
}