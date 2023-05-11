package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import java.text.FieldPosition

class ViewStudyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.view_study1)
        setContentView(R.layout.view_study2)

        var spinner = findViewById<Spinner>(R.id.my_spinner)

        var menuItems = arrayOf("Item 1", "Item 2", "Item 3")
        val adapter: ArrayAdapter<String?> = ArrayAdapter<String?> (
            this,
            android.R.layout.simple_spinner_item,
            menuItems
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>, p1: View?, position: Int, id: Long) {
                val selectedItem = p0?.getItemAtPosition(position).toString()
                Log.d("mytag", selectedItem);
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}