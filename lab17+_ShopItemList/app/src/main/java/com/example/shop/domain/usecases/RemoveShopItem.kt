package com.example.shop.domain.usecases

import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository

class RemoveShopItem (
    val repository: ShopItemRepository
){
    fun removeShopItem(item: ShopItem){
        repository.removeShopItem(item)
    }
}