package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifecycleDemoActivity : AppCompatActivity() {
    // 무조건 정의
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_demo)
        Log.d("mytag", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("mytag", "onStart")
    }

    // 다시 액티비티로 돌아왔을 때 필요한 변수, 환경 정보를 이용해 화면 복구 작업 진행
    // ex: 브라우저에서 보고 있던 이전 화면 주소 불러오기
    override fun onResume() {
        super.onResume()
        Log.d("mytag", "onResume")
    }

    // 다시 액티비티로 돌아왔을 때 필요한 변수, 환경 정보 등 저장
    // ex: 브라우저에서 보고 있던 화면의 주소를 저장
    override fun onPause() {
        super.onPause()
        Log.d("mytag", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("mytag", "onStop")
    }

    // 정리 해야 할 작업(ex: 음악 재생 끄기)이 있을 때
    // 반드시 실행된다는 보장 x -> onStop을 대용으로 쓰기도 함
    override fun onDestroy() {
        super.onDestroy()
        Log.d("mytag", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mytag", "onRestart")
    }
}