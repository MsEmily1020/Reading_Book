package com.example.hozuandroidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hozuandroidstudy.api.APIService
import com.example.hozuandroidstudy.api.AllPostResponse
import com.example.hozuandroidstudy.api.PostCreateRequest
import com.example.hozuandroidstudy.api.PostResponse
import com.example.hozuandroidstudy.api.StringResponse
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
        // getPosts()
        // getPost(2)
        val post = PostCreateRequest("title1", "author1", "content1")
        createPost(post)
        deletePost(2)
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

    fun getPost(id: Int) {
        val call = apiService.getPost(id)
        call.enqueue(object: Callback<PostResponse> {
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if(response.isSuccessful) {
                    val data: PostResponse? = response.body()

                    data?.let {
                        Log.d("mytag", it.result.toString())
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {}
        })
    }

    fun createPost(post: PostCreateRequest) {
        val call = apiService.createPost(post)
        call.enqueue(object: Callback<StringResponse> {
            override fun onResponse(call: Call<StringResponse>, response: Response<StringResponse>) {
                val data: StringResponse? = response.body()
                data?.let {
                    Log.d("mytag", it.result.toString())
                }
            }

            override fun onFailure(call: Call<StringResponse>, t: Throwable) {}

        })
    }

    fun deletePost(id: Int) {
        val call = apiService.deletePost(id)
        call.enqueue(object: Callback<StringResponse> {
            override fun onResponse(call: Call<StringResponse>, response: Response<StringResponse>) {
                val data: StringResponse? = response.body()
                data?.let {
                    Log.d("mytag", it.result.toString())
                }
            }

            override fun onFailure(call: Call<StringResponse>, t: Throwable) {}

        })
    }
}