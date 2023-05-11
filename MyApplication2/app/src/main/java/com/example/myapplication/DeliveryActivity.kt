package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DeliveryActivity : AppCompatActivity() {
    // 무조건 정의
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nation_of_delivery)

        supportActionBar?.hide() // My Application Bar 숨김

    }
}