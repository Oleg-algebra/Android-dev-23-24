package com.example.shop.domain.usecases

import com.example.shop.domain.ShopItemRepository

class GetItemList(
    val repository: ShopItemRepository
) {
    fun getItemList() = repository.getItemsList()
}