package com.example.todayquote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CalcInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_input_activity)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)


        btnPlus.setOnClickListener {
            var num1Str = number1.text.toString()
            var num2Str = number2.text.toString()
            if (num1Str.isNotBlank() && num2Str.isNotBlank()) {
                val numText1 = num1Str.trim().toInt()
                val numText2 = num2Str.trim().toInt()
                val intent = Intent(
                    this,
                    CalcResultAcitivity::class.java
                )
                intent.putExtra("number1", numText1)
                intent.putExtra("number2", numText2)
                intent.putExtra("operator", "+")
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "잘못된 입력값", Toast.LENGTH_SHORT).show()
            }
        }

        btnMinus.setOnClickListener {
            var num1Str = number1.text.toString()
            var num2Str = number2.text.toString()
            if (num1Str.isNotBlank() && num2Str.isNotBlank()) {
                val numText1 = num1Str.trim().toInt()
                val numText2 = num2Str.trim().toInt()
                val intent = Intent(
                    this,
                    CalcResultAcitivity::class.java
                )
                intent.putExtra("number1", numText1)
                intent.putExtra("number2", numText2)
                intent.putExtra("operator", "-")
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "잘못된 입력값", Toast.LENGTH_SHORT).show()
            }
        }

        btnMultiply.setOnClickListener {
            var num1Str = number1.text.toString()
            var num2Str = number2.text.toString()
            if (num1Str.isNotBlank() && num2Str.isNotBlank()) {
                val numText1 = num1Str.trim().toInt()
                val numText2 = num2Str.trim().toInt()
                val intent = Intent(
                    this,
                    CalcResultAcitivity::class.java
                )
                intent.putExtra("number1", numText1)
                intent.putExtra("number2", numText2)
                intent.putExtra("operator", "*")
                startActivity(intent)
            }

            else {
                Toast.makeText(this, "잘못된 입력값", Toast.LENGTH_SHORT).show()
            }
        }
    }
}