package com.example.hozuandroidstudy.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Date

data class Post(val id: Int, var title: String, var author: String, var createdAt: Date, var content: String)
data class AllPostResponse(val result: List<Post>)
data class PostResponse(val result: Post)

interface APIService {
    @GET("/posts")
    fun getPosts(): Call<AllPostResponse>

    @GET("/posts/{id}")
    fun getPost(@Path("id") id: Int) : Call<PostResponse>
}