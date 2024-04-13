package com.example.retrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        val product = intent.getParcelableExtra<Product>("product")!!

        val id = findViewById<TextView>(R.id.product_id)
        val title = findViewById<TextView>(R.id.product_title)
        val description = findViewById<TextView>(R.id.product_description)
        val price = findViewById<TextView>(R.id.product_price)
        val discountPercentage = findViewById<TextView>(R.id.product_discountPercentage)
        val images = findViewById<ImageView>(R.id.product_image)

        id.text = product.id.toString()
        title.text = product.title
        description.text = product.description
        price.text = product.price.toString()
        discountPercentage.text = product.discountPercentage.toString()

        Glide.with(this)
            .load(product.images[0])
            .into(images)
    }
}