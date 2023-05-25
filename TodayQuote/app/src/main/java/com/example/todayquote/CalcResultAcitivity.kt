package com.example.todayquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class CalcResultAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_result_acitivity)
        val number1 = intent.getIntExtra("number1", -1)
        val number2 = intent.getIntExtra("number2", -1)
        val operator = intent.getStringExtra("operator")

        val result = findViewById<TextView>(R.id.textResult)

        when (operator) {
            "+" -> result.text = (number1 + number2).toString()
            "-" -> result.text = (number1 - number2).toString()
            "*" -> result.text = (number1 * number2).toString()
        }
    }
}