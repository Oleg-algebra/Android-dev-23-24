package com.example.shop.domain.usecases

import androidx.lifecycle.LiveData
import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository

class GetItemList(
    val repository: ShopItemRepository
) {
    fun getItemList(): LiveData<List<ShopItem>> = repository.getItemsList()
}