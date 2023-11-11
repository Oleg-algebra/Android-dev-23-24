package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    private lateinit var imageView: ImageView
    private lateinit var catsList: RecyclerView
    private val TAG = "XXXXX"

    private val listItemData: List<ItemData> = listOf(
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),
        ItemData("Cat 1",R.drawable.cat_1),
        ItemData("Cat 2",R.drawable.cat_2),
        ItemData("Cat 3",R.drawable.cat_3),
        ItemData("Cat 4",R.drawable.cat_4),
        ItemData("Cat 5",R.drawable.cat_5),
        ItemData("Cat 6",R.drawable.cat_6),
        ItemData("Cat 7",R.drawable.cat_7),

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        catsList = findViewById(R.id.cat_list)
        catsList.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(listItemData).apply {
            clickListener =
                CustomAdapter.CatItemClickListener { view, itemData
                    -> Toast.makeText(this@MainActivity,itemData.name,Toast.LENGTH_SHORT).show()
                    imageView.setImageResource(itemData.resId)
                }
        }
        catsList.adapter = adapter


    }
}