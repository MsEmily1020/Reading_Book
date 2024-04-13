package com.example.fragmentstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), CommunicationFragmentListener {
    override fun sendMessage(msg: String) {
        Log.d("mytag", msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FirstFragment())
            .commit()

        findViewById<Button>(R.id.add).setOnClickListener {
            findViewById<Button>(R.id.add_button).setOnClickListener {
                val input1EditText = findViewById<EditText>(R.id.input1_text).text.toString().toInt()
                val input2EditText = findViewById<EditText>(R.id.input2_text).text.toString().toInt()

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AddFragment.newInstance(input1EditText, input2EditText))
                    .commit()
            }
        }

        findViewById<Button>(R.id.first).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())
                .commit()
        }

        findViewById<Button>(R.id.second).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())
                .commit()
        }

        findViewById<Button>(R.id.args).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ArgumentsFragment.newInstance("hello"))
                .commit()
        }

        findViewById<Button>(R.id.comm).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CommunicationFragment())
                .commit()
        }
    }
}