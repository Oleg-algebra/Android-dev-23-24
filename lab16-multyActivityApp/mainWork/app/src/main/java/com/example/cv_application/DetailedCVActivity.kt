package com.example.cv_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import io.noties.markwon.Markwon
import java.io.File

class DetailedCVActivity : AppCompatActivity() {
    lateinit var cvText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_cvactivity)
        cvText = findViewById(R.id.detailedCV)
        cvText.text = getString(R.string.detailedCV)
    }
}