package com.example.retrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create()) // Json데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리
            .build() //레트로핏 구현체 완성!

        val productService = retrofit.create(ProductService::class.java)
        val call = productService.getProducts()
        val productList = findViewById<RecyclerView>(R.id.product_list)
        productList.setHasFixedSize(true)
        productList.layoutManager = LinearLayoutManager(this)

        call.enqueue(object : Callback<ProductDTO> {
            override fun onResponse(call: Call<ProductDTO>, response: Response<ProductDTO>) {
                val dto = response.body() as ProductDTO

                dto?.let {
                    for(obj in it.products) {
                        productList.adapter = MainContact(dto.products)
                    }
                }

                // RecyclerView가 고정된 사이즈를 가진다고 알려주는 함수
                // 내부적으로 Size를 측정하여 자신의 Size를 결정하고 이는 비용이 많이 드는 작업이다.

            }

            override fun onFailure(call: Call<ProductDTO>, t: Throwable) {
            }
        })
    }
}