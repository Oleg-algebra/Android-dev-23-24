package com.example.shop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shop.R
import com.example.shop.data.ShopItemRepositoryImpl
import com.example.shop.domain.ShopItem
import com.example.shop.domain.usecases.GetItemList
import com.example.shop.domain.usecases.RemoveShopItem

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var removeButton: Button
    lateinit var viewModel: MainViewModel

    var item :ShopItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        removeButton = findViewById(R.id.button_remove)

        val repository = ShopItemRepositoryImpl()
        val getItemsUsecase = GetItemList(repository)
        val removeItemUseCase = RemoveShopItem(repository)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.liveData.observe(this){
            item = if(it.isNotEmpty()) it[0] else null
            Log.d(TAG, "Main view model live data: $it ")
        }

        button.setOnClickListener {
            viewModel.getItemsList()
        }
        removeButton.setOnClickListener{
            item?.let { viewModel.removeItem(it) }

        }



    }

    companion object{
        const val TAG = "XXX"
    }
}