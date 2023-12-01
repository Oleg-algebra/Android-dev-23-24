package com.example.shop.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {
    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)
    fun getShopItem(id: Long): ShopItem
    fun getItemsList(): LiveData<List<ShopItem>>
    fun removeShopItem(item: ShopItem)

}