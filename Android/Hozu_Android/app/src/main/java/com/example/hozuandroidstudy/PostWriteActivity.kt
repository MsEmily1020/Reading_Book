package com.example.hozuandroidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hozuandroidstudy.api.APIService
import com.example.hozuandroidstudy.api.PostCreateRequest
import com.example.hozuandroidstudy.api.StringResponse
import com.example.retrofit_study.Config
import com.example.retrofit_study.Config.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostWriteActivity : AppCompatActivity() {
    lateinit var apiService : APIService
    lateinit var writeBtn : Button
    lateinit var titleEdit : EditText
    lateinit var authorEdit : EditText
    lateinit var contentEdit : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_write)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)

        writeBtn = findViewById(R.id.post_write_btn)
        titleEdit = findViewById(R.id.post_title)
        authorEdit = findViewById(R.id.post_author)
        contentEdit = findViewById(R.id.post_content)

        writeBtn.setOnClickListener {
            createPost(
                titleEdit.text.toString(),
                authorEdit.text.toString(),
                contentEdit.text.toString()
            )
        }
    }

    fun createPost(title: String, author: String, content: String) {
        val call = apiService.createPost(PostCreateRequest(title, author, content))
        call.enqueue(object: Callback<StringResponse> {
            override fun onResponse(call: Call<StringResponse>, response: Response<StringResponse>) {
                    Toast.makeText(this@PostWriteActivity,"글 작성이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                    this@PostWriteActivity.finish()
            }

            override fun onFailure(call: Call<StringResponse>, t: Throwable) {}
        })
    }
}