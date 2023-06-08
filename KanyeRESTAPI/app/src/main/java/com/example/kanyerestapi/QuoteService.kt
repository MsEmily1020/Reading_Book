package com.example.kanyerestapi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class Quote(val quote: String)

interface ProductService {
    @GET("/quote")
    fun getProduct() : Call<Quote>
}