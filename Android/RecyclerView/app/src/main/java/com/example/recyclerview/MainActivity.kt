package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val data: List<String>) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    // viewHolder를 만듦
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        return ItemViewHolder(view)
    }

    // view에 데이터 값 넣기
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val view = holder.view
        val listItemText = view.findViewById<TextView>(R.id.list_item_text)
        val item = data[position]
        listItemText.text = item

        // holder.view.findViewById<TextView>(R.id.list_item_text).text = data[position]
    }

    // 데이터 총갯수
    override fun getItemCount(): Int {
        return data.size
    }

    // 해당 목록 아이템에 해당하는 레이아웃 (사실 switch로 각각 맞는 레이아웃 return 시켜줘야함)
    override fun getItemViewType(position: Int): Int {
        return R.layout.list_item
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = mutableListOf<String>()
        for (i in 1..100) {
            data.add("apple")
            data.add("banana")
            data.add("orange")
        }

        val listView = findViewById<RecyclerView>(R.id.list)
        listView.setHasFixedSize(false)
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = ListAdapter(data)


    }
}
