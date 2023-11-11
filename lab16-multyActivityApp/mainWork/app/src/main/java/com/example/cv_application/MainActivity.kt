package com.example.cv_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var photo: ImageView
    lateinit var email: TextView
    lateinit var number: TextView
    lateinit var cvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        photo = findViewById(R.id.imageView)
        email = findViewById(R.id.e_mail)
        number = findViewById(R.id.number)
        cvInfo = findViewById(R.id.shortCV)

        photo.setOnClickListener {
            val intent = Intent(this,PhotoViewsActivity::class.java)
            startActivity(intent)
        }
        email.setOnClickListener{
            val intent = Intent(this,EmailActivity::class.java)
            startActivity(intent)
        }
        number.setOnClickListener{
            val intent = Intent(this,CallNumber::class.java)
            startActivity(intent)
        }

        cvInfo.setOnClickListener{
            val intent = Intent(this,DetailedCVActivity::class.java)
            startActivity(intent)
        }

    }

    companion object{
        const val EXTRA_NAME = "name"
        const val EXTRA_NUMBER = "number"
    }
}