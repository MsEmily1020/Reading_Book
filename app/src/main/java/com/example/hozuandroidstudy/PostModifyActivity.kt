package com.example.hozuandroidstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hozuandroidstudy.api.APIService
import com.example.hozuandroidstudy.api.Post
import com.example.hozuandroidstudy.api.StringResponse
import com.example.retrofit_study.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostModifyActivity : AppCompatActivity() {
    lateinit var apiService: APIService
    lateinit var titleEdit : EditText
    lateinit var authorEdit : EditText
    lateinit var contentEdit : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_modify)

        val retrofit = Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(APIService::class.java)

        val post = intent.getSerializableExtra("post") as Post

        titleEdit = findViewById(R.id.post_title)
        authorEdit = findViewById(R.id.post_author)
        contentEdit = findViewById(R.id.post_content)

        titleEdit.setText(post.title)
        authorEdit.setText(post.author)
        contentEdit.setText(post.content)

        findViewById<Button>(R.id.post_modify_btn).setOnClickListener {
            modifyPost(
                post.id,
                mutableMapOf(
                    "title" to findViewById<EditText>(R.id.post_title).text.toString(),
                    "author" to findViewById<EditText>(R.id.post_author).text.toString(),
                    "content" to findViewById<EditText>(R.id.post_content).text.toString()
                )
            )
        }
    }

    fun modifyPost(id:Int, body: MutableMap<String, Any>){
        val call = apiService.modifyPOST(id, body)
        call.enqueue(object: Callback<StringResponse> {
            override fun onResponse(call: Call<StringResponse>, response: Response<StringResponse>) {
                Toast.makeText(this@PostModifyActivity,"글이 수정되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailure(call: Call<StringResponse>, t: Throwable) {}
        })
    }
}