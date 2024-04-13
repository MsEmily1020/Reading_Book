package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import org.w3c.dom.Text

class ContactMusicDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val img = intent.getIntExtra("img",-1)
        val name = intent.getStringExtra("name")
        val genre = intent.getStringExtra("genre")

        val contactImgImageView = findViewById<ImageView>(R.id.detail_contact_img)
        val contactNameTextView = findViewById<TextView>(R.id.detail_contact_name)
        val contactGenreTextView = findViewById<TextView>(R.id.detail_contact_genre)

        // TODO : image 없음. 오류 고치기
        contactImgImageView.setImageResource(img)
        contactNameTextView.text = name
        contactGenreTextView.text = genre
    }
}