package com.example.shop.data

import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository

class ShopItemRepositoryImpl : ShopItemRepository {

    var currentId = 0L
    val shopItemList = mutableListOf<ShopItem>()

    init {
        for ( i in 1..5){
            addShopItem(
                ShopItem("Item $i",i,currentId++)
            )
        }
    }
    override fun addShopItem(item: ShopItem) {
        shopItemList.add(item)
    }

    override fun editShopItem(item: ShopItem) {
        val oldItem = getShopItem(item.id)
        removeShopItem(oldItem)
        addShopItem(item)
    }

    override fun getShopItem(id: Long): ShopItem {
        return shopItemList.find { it.id == id }
            ?:throw RuntimeException("Item not found")
    }

    override fun getItemsList(): List<ShopItem> {
        return shopItemList.toList()
    }

    override fun removeShopItem(item: ShopItem) {
        shopItemList.remove(item)
    }
}