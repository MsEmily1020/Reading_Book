package com.example.hozuandroidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hozuandroidstudy.api.APIService
import com.example.hozuandroidstudy.api.AllPostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var apiService : APIService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)
        getPosts()
    }

    fun getPosts() {
        val call = apiService.getPosts()
        call.enqueue(object : Callback<AllPostResponse> {
            override fun onResponse(call: Call<AllPostResponse>, response: Response<AllPostResponse>) {
                val data : AllPostResponse? = response.body()

                data?.let {
                    Log.d("mytag", it.result.toString())
                }
            }

            override fun onFailure(call: Call<AllPostResponse>, t: Throwable) {}
        })
    }
}