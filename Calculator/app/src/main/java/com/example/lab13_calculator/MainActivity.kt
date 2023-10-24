package com.example.lab13_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.License
import java.io.File

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textView.text = "0"
        val layout1 = findViewById<LinearLayout>(R.id.linearLayout2).touchables

        Log.d("1111",License.iConfirmNonCommercialUse("Oleh").toString())
        Log.d("1111",License.checkIfUseTypeConfirmed().toString())
        Log.d("1111",License.getUseTypeConfirmationMessage())

        for( btn in layout1){
            btn.setOnClickListener(this)
        }
    }

    private fun makeInput(btn: View?){
        btn?.let {
            if(it is Button) {
                var currentText = textView.text.toString()

                if (currentText == "0" || currentText == "NaN"){
                    var newText = if(it.text.toString() == "."){
                        "$currentText."
                    }else{
                        it.text.toString()
                    }

                    if (it.tag.toString() == "operator"){
                        newText+="("
                    }
                    textView.text = newText
                }else {
                    val operaitons = listOf("+","-","*","/",".")
                    if(currentText.last().toString() in operaitons && it.text.toString() in operaitons){
                        currentText = currentText.substring(0,currentText.length-1)
                    }
                    currentText += it.text.toString()
                    if(it.tag.toString() == "operator"){
                        currentText+="("
                    }
                    textView.text = currentText

                }

            }
        }
    }

    private fun doAction(btn: View?) {
        btn?.let {
            if (it is Button) {
                when (it.text.toString()) {
                    "C" -> {
                        var text = textView.text.toString()
                        text = text.substring(0, text.length - 1)
                        if(text.length == 0){
                            text = "0"
                        }
                        textView.text = text
                    }

                    "AC" -> {
                        textView.text = "0";
                    }

                    "%" -> {
                        val currentText = textView.text.toString().toDouble()
                        textView.text = (currentText * 0.01).toString()
                    }
                    "=" ->{
                        val res = Expression(textView.text.toString()).calculate()
                        val res_int = res.toInt()

                        textView.text = if(res - res_int == 0.0){
                            res_int.toString()
                        }else{
                            res.toString()
                        }

                    }
                }
            }
        }
    }



    override fun onClick(btn: View?) {
        btn?.let {
            if (it is Button) {
//                val toast = Toast.makeText(this, it.text.toString(), Toast.LENGTH_SHORT)
//                toast.show()
                val tag = it.tag.toString()
                if( tag == "input" || tag == "operator"){
                    makeInput(it)
                }
                if (tag == "action"){
                    doAction(it)
                }
            }
        }
    }
}