package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// ViewGroup : 보통은 ConstraintLayout (까다로움)
// 1. LinearLayout
// 2. RelativeLayout

class ViewGroupDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nested_viewgroup_demo)
        supportActionBar?.hide() // My Application Bar 숨김
    }
}