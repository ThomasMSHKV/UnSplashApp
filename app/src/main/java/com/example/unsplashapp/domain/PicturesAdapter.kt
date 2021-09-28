package com.example.unsplashapp.domain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplashapp.R
import com.example.unsplashapp.data.MainObjectClass

class PicturesAdapter(var context: Context) : RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {
    val itemPict = mutableListOf<MainObjectClass>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent,false)
        val  holder = ViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(itemPict[position].results[position].urls).into(holder.image)
    }

    override fun getItemCount(): Int {
        return itemPict.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.pictures_img)
    }
}
