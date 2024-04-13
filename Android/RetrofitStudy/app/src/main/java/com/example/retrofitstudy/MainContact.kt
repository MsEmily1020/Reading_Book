package com.example.retrofitstudy

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainContact(val data: List<Product>) : RecyclerView.Adapter<MainContact.ItemViewHolder>() {
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
        val idTextView = holder.view.findViewById<TextView>(R.id.detail_contact_id)
        val titleTextView = holder.view.findViewById<TextView>(R.id.detail_contact_title)
        val descriptionTextView = holder.view.findViewById<TextView>(R.id.detail_contact_description)
        val priceTextView = holder.view.findViewById<TextView>(R.id.detail_contact_price)
        val discoutPercentageTextView = holder.view.findViewById<TextView>(R.id.detail_contact_discountPercentage)
        val imagesTextView = holder.view.findViewById<TextView>(R.id.detail_contact_images)

        idTextView.text = item.id.toString()
        titleTextView.text = item.title
        descriptionTextView.text = item.description
        priceTextView.text = item.price.toString()
        discoutPercentageTextView.text = item.discountPercentage.toString()
        imagesTextView.text = item.images.toString()

        holder.view.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra("product", data[position])
            holder.view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.acitvity_contact
    }
}