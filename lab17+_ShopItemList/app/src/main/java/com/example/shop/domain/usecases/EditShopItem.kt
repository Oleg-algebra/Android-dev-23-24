package com.example.shop.domain.usecases

import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository

class EditShopItem(
    val repository: ShopItemRepository
) {
    fun editShopItem(item: ShopItem){
        repository.editShopItem(item)
    }
}