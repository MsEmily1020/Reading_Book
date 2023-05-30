package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListContact(val data: List<String>) : RecyclerView.Adapter<ListContact.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    // viewHolder를 만듦
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListContact.ItemViewHolder, position: Int) {
        val view = holder.view
        val listItemText = view.findViewById<TextView>(R.id.list_item_text)
        val item = data[position]
        listItemText.text = item
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
class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_activity)

    }
}