package com.example.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

class DynamicViewStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dynamic_view_study_activity)

        val layout = findViewById<LinearLayout>(R.id.root_view_group)
        val btn = Button(this)

        // 부모와 관계 있기 때문에 LinearLayout은 부모에 의해 정의됨.
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        btn.layoutParams = params
        btn.text = "Hello"
        btn.setTextColor(Color.RED)
        btn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        btn.setBackgroundColor(Color.LTGRAY)

        val editText = EditText(this)

        // dp -> px 변경
        val width = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            100f,
            resources.displayMetrics
        ).toInt()

        val height = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            50f,
            resources.displayMetrics
        ).toInt()

        // LayoutParams(px, px)
        editText.layoutParams = LinearLayout.LayoutParams(width, height)

        editText.hint = "Hint"

        layout.addView(btn)
        layout.addView(editText)
    }
}