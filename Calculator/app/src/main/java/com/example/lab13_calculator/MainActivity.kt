package com.example.lab13_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import org.mariuszgromada.math.mxparser.Expression
import org.mariuszgromada.math.mxparser.License


class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var textView: TextView
    private lateinit var textViewCalculations: TextView
    private var savedNumber: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textViewCalculations = findViewById(R.id.calculations_result)

//        textView.text = "0"
        val layout1 = findViewById<LinearLayout>(R.id.linearLayout2).touchables

        Log.d("1111",License.iConfirmNonCommercialUse("OlehT").toString())
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
                    val operations = listOf("+","-","*","/",".","^")
                    if(currentText.last().toString() in operations && it.text.toString() in operations){
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
                        if(text.isEmpty()){
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
                        if(res.isNaN()){
                            Log.e("action", "incorrect expression: ${textView.text}")
                        }
                        textView.text = if(checkIfAlmostIntRounding(res)){
                            res.toInt().toString()
                        }else{
                            res.toString()
                        }
                        textViewCalculations.visibility = GONE

                    }
                }
            }
        }
    }

    private fun checkIfAlmostIntRounding(res: Double) = (res - res.toInt()) < 1e-10

    private fun updateTextCalculationsResults(){
        val expr = textView.text.toString()
        val res = Expression(expr).calculate()

        val textUpdate = if(checkIfAlmostIntRounding(res)){
            res.toInt().toString()
        }else{
            res.toString()
        }
        textViewCalculations.text = "=$textUpdate"
    }

    override fun onClick(btn: View?) {
        btn?.let {
            if (it is Button) {
                textViewCalculations.visibility = VISIBLE
                Log.d("action", "pressed button: ${it.text}")

                val tag = it.tag.toString()
                if( tag == "input" || tag == "operator"){
                    makeInput(it)
                }else if (tag == "action"){
                    doAction(it)
                }else{
                    memoryOperation(it.text.toString())?.let {storedNumber ->
                        val lastChar = textView.text.toString().last().toString()
                        if ( lastChar in listOf("+","-","*","/","(","^")){
                            val newText = textView.text.toString() + storedNumber
                            textView.text = newText
                        }

                    }

                }
                updateTextCalculationsResults()
            }
        }
    }

    private fun memoryOperation(command: String): String? {
        val toast = Toast.makeText(this,"",LENGTH_SHORT)
        when(command){
            "M+" -> {
                val exprResult = Expression(textView.text.toString()).calculate()
                if(!exprResult.isNaN()){
                    savedNumber = exprResult
                    toast.setText("number $savedNumber saved")
                }else{
                    toast.setText("saving failed!")
                }
            }
            "MR" -> {

                toast.setText("number $savedNumber read")
                toast.show()
                if(savedNumber != null) {
                    return savedNumber.toString()
                }
            }
            "MC" -> {toast.setText("memory cleaned");savedNumber = null}
        }
        toast.show()
        return null
    }
}