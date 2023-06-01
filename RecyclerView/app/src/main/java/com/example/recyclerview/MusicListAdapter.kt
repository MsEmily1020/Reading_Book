package com.example.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicListAdapter(val data: List<Music>) : RecyclerView.Adapter<MusicListAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(viewType, parent, false)
        // viewType : Layout id
        // parent : ViewGroup
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        val nameTextView = holder.view.findViewById<TextView>(R.id.music_name)
        val genreTextView = holder.view.findViewById<TextView>(R.id.music_genre)
        val imgImageView = holder.view.findViewById<ImageView>(R.id.music_img)
        nameTextView.text = item.name
        genreTextView.text = item.genre
        imgImageView.setImageResource(item.img)

        holder.view.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, ContactMusicDetailActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("genre", item.genre)
            intent.putExtra("img", item.img)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.music_item
    }
}