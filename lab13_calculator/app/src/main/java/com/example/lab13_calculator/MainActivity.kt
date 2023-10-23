package com.example.lab13_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var textView: TextView
    val maxLength = 13
    var currentOperation = ""
    var number1 = Double.MAX_VALUE
    var number2 = Double.MAX_VALUE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textView.text = "0"

        val listOfButtons = listOf<View>(
            findViewById(R.id.num_0),
            findViewById(R.id.num_1),
            findViewById(R.id.num_2),
            findViewById(R.id.num_3),
            findViewById(R.id.num_4),
            findViewById(R.id.num_5),
            findViewById(R.id.num_6),
            findViewById(R.id.num_7),
            findViewById(R.id.num_8),
            findViewById(R.id.num_9),
            findViewById(R.id.clear_all),
            findViewById(R.id.delete),
            findViewById(R.id.pi),
            findViewById(R.id.point),
            findViewById(R.id.procents),
            findViewById(R.id.add),
            findViewById(R.id.substract),
            findViewById(R.id.division),
            findViewById(R.id.multyplication),
            findViewById(R.id.equal),
            findViewById(R.id.e),
            findViewById(R.id.sin),
            findViewById(R.id.cos),
            findViewById(R.id.tan),
            findViewById(R.id.left_parentheses),
            findViewById(R.id.right_parentheses),
            findViewById(R.id.lg),
            findViewById(R.id.ln),
            findViewById(R.id.sqrt),
            findViewById(R.id.pow),
        )
        for( btn in listOfButtons){
            btn.setOnClickListener(this)
        }
    }

    private fun makeInput(btn: View?){
        btn?.let {
            if(it is Button) {
                var currentText = textView.text.toString()

                if (currentText == "0" || currentText == "NaN"){
                    var newText = it.text.toString()
                    if (it.tag.toString() == "operator"){
                        newText+="("
                    }
                    textView.text = newText
                }else {
                    val operaitons = listOf("+","-","*","/")
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
                        currentOperation = "";
                        number1 = Double.MAX_VALUE
                        number2 = Double.MAX_VALUE
                    }

                    "%" -> {
                        val currentText = textView.text.toString().toDouble()
                        textView.text = (currentText * 0.01).toString()
                    }
                    "=" ->{
                        val res = Expression(textView.text.toString()).calculate()
                        textView.text = res.toString()
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