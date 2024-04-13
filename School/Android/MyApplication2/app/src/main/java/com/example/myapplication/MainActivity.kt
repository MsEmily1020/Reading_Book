package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.log

// : -> 상속
// AppCompatActivity() : 생성자
// Activity 클래스 : 하나의 "화면"을 정의하는데 사용하는 클래스
// Activity는 context를 상속받는 Context 타입의 객체 (Context 타입 객체 요구 메서드 많음)
// Activity 안은 this
// 명시적인 this : this@MainActivity

class MainActivity : AppCompatActivity() {
    var count = 0
    // onCreate 메서드 오버라이드
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        // 안드로이드 특정 메서드 반드시 super 통해 부모 메서드 호출
        // 1. XML 레이아웃 파일을 이용해서 화면 구성
        // 2. 화면에서 사용할 데이터 초기화
        // 3. 뷰 객체를 통해 이벤트 리스너 등록
        super.onCreate(savedInstanceState)
        // 1. XML 레이아웃 파일을 이용해서 화면 구성
        // R : Resource
        setContentView(R.layout.counter)
//        val color = ContextCompat.getColor(this, R.color.red)
//        println("color : " + color)
//
//        var btn = findViewById<Button>(R.id.click)
//        btn.setOnClickListener {
//            Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show()
//        }

        val countText : TextView = findViewById<TextView>(R.id.count)
        val plusBtn = findViewById<Button>(R.id.btn_plus)
        val minusBtn : Button = findViewById(R.id.btn_minus)


        plusBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                count++
                Log.d("mytag", count.toString())
                Toast.makeText(this@MainActivity, count.toString(), Toast.LENGTH_SHORT).show()
                countText.text = count.toString()
            }
        })

        minusBtn.setOnClickListener {
            if(count != 0) count--
            Log.e("mytag", count.toString())
            countText.text = count.toString()
        }
    }
}