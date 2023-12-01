package com.example.shop.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItem.Companion.UNDEFINED
import com.example.shop.domain.ShopItemRepository

class ShopItemRepositoryImpl : ShopItemRepository {
    private val liveData = MutableLiveData<List<ShopItem>>()

    private var currentId = 0L
    private val shopItemList =  sortedSetOf<ShopItem>({ o1, o2 ->
        o1.id.compareTo(o2.id)
    })
    init {
        for ( i in 1..5){
            addShopItem(
                ShopItem("Item $i",i,++currentId)
            )
        }
    }
    override fun addShopItem(item: ShopItem) {
        if(item.id == UNDEFINED) item.id = currentId++
        shopItemList.add(item)
        update()
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

    override fun getItemsList(): LiveData<List<ShopItem>> {
        return liveData.apply {
            update() }
    }

    override fun removeShopItem(item: ShopItem) {
        shopItemList.remove(item)
        update()
    }

    fun update(){
        liveData.value = shopItemList.toList()
    }
}