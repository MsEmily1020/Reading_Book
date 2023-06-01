package com.example.retrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit= Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
            .build() //레트로핏 구현체 완성!

        val productService = retrofit.create(ProductService::class.java)
        val call = productService.getProduct(1)

        val id = findViewById<TextView>(R.id.product_id)
        val title = findViewById<TextView>(R.id.product_title)
        val description = findViewById<TextView>(R.id.product_description)
        val price = findViewById<TextView>(R.id.product_price)
        val discountPercentage = findViewById<TextView>(R.id.product_discoutPercentage)

        call.enqueue(object: Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                val body = response.body() as Product?
                body?.let {
                    id.text = it.id.toString()
                    title.text = it.title
                    description.text = it.description
                    price.text = it.price.toString()
                    discountPercentage.text = it.discountPercentage.toString()
                }
                /*
                if(boyd != null) {
                    Log.d("mytag", body.toString())
                }
                 */

            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("mytag", "실패")
            }
        })
    }
}