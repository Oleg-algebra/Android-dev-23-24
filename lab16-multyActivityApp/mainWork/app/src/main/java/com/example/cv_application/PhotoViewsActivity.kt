package com.example.cv_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.cv_application.MainActivity.Companion.EXTRA_NAME
import com.example.cv_application.MainActivity.Companion.EXTRA_NUMBER

class PhotoViewsActivity : AppCompatActivity() {

    private lateinit var button: Button
    lateinit var message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_view_activity)

//        button = findViewById(R.id.button2)
//        message = findViewById(R.id.message)
//
//
//        button.setOnClickListener{
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        val name = intent.getStringExtra(EXTRA_NAME)
//        val number = intent.getStringExtra(EXTRA_NUMBER)
//
//        Log.d("XXXX", "name: $name, number: $number")
//        message.text = "Name: $name --- number: $number"


    }
}