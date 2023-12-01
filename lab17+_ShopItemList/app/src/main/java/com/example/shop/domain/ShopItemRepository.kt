package com.example.shop.domain

interface ShopItemRepository {
    fun addShopItem(item: ShopItem)

    fun editShopItem(item: ShopItem)
    fun getShopItem(id: Long): ShopItem
    fun getItemsList(): List<ShopItem>
    fun removeShopItem(item: ShopItem)

}