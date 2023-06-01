package com.example.retrofitstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Product(val id: Int, val title: String, val description: String, val price: Int, val discountPercentage: Double)

interface ProductService {
    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int) : Call<Product>
}