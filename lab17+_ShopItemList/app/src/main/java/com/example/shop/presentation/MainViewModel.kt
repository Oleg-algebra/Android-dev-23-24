package com.example.shop.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop.data.ShopItemRepositoryImpl
import com.example.shop.domain.ShopItem
import com.example.shop.domain.ShopItemRepository
import com.example.shop.domain.usecases.EditShopItem
import com.example.shop.domain.usecases.GetItemList
import com.example.shop.domain.usecases.RemoveShopItem

class MainViewModel: ViewModel() {

    val repository = ShopItemRepositoryImpl()

    val getShopItemsListUseCase = GetItemList(repository)
    val editShopItemUseCase = EditShopItem(repository)
    val removeShopItemUseCase = RemoveShopItem(repository)

    val liveData: LiveData<List<ShopItem>>
        get() = getShopItemsListUseCase.getItemList()

    fun getItemsList(){
        getShopItemsListUseCase.getItemList()
    }

    fun toggleItemActivity(item: ShopItem) {
        editShopItemUseCase.editShopItem(item)
    }
    fun removeItem(item: ShopItem){
        removeShopItemUseCase.removeShopItem(item)
        getItemsList()
    }
}