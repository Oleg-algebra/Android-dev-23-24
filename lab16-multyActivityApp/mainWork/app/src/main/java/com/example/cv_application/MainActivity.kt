package com.example.cv_application

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.content.Intent.ACTION_SEND
import android.content.Intent.ACTION_SENDTO
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var photo: ImageView
    lateinit var email: TextView
    lateinit var number: TextView
    lateinit var cvInfo: TextView

    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        photo = findViewById(R.id.imageView)
        email = findViewById(R.id.e_mail)
        number = findViewById(R.id.number)
        cvInfo = findViewById(R.id.shortCV)

        number.text = number.text.toString()+" ${getString(R.string.number)}"
        email.text = email.text.toString()+" ${getString(R.string.email)}"
        cvInfo.text = cvInfo.text.toString()+"\n${getString(R.string.shortCV)}"

        photo.setOnClickListener {
            val intent = Intent(this,PhotoViewsActivity::class.java)
            Toast.makeText(this,"Photo clicked",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        email.setOnClickListener{
            Toast.makeText(this,"Email clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(ACTION_SEND)
            intent.type = "message/rfc822"         //"message/rfc822"   "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf( getString(R.string.email)))
            intent.putExtra(Intent.EXTRA_SUBJECT,"Запрошення на зустріч")
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.meetingInvitaion))
            intent.setPackage("com.google.android.gm")
            val mailer = Intent.createChooser(intent,null)
            Log.e(TAG, "email intent", )
            startActivity(mailer)
        }
        number.setOnClickListener{
            Toast.makeText(this,"Number clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(ACTION_DIAL)

            intent.data = Uri.parse("tel:" + Uri.encode(getString(R.string.number)))
            Log.e(TAG, "number call intent", )
            startActivity(intent)
        }

        cvInfo.setOnClickListener{
            Toast.makeText(this,"CV info clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,DetailedCVActivity::class.java)
            startActivity(intent)
        }

    }

    companion object{
        const val TAG = "XXXX"
    }
}