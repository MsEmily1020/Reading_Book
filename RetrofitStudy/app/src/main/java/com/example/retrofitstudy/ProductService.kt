package com.example.retrofitstudy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

@Parcelize
data class Product(val id: Int,
                   val title: String,
                   val description: String,
                   val price: Int,
                   val discountPercentage: Double,
                   val images: List<String>) : Parcelable

data class ProductDTO(var products: List<Product>)

interface ProductService {
    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int) : Call<Product>

    @GET("/products")
    fun getProducts() : Call<ProductDTO>
}