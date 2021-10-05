package com.example.unsplashapp.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplashapp.R
import com.example.unsplashapp.data.Result
import com.example.unsplashapp.view.OrdersCallback

class PicturesAdapter(private val callback: OrdersCallback) :
    RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {

    var itemPict = mutableListOf<Result>()
    private var count: Int = 0

    fun setData(list: MutableList<Result>) {
        itemPict.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.image.setOnClickListener {
           callback.openFragment(itemPict[holder.adapterPosition].id,count)

        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(itemPict[position].urls.small).into(holder.image)
    }

    override fun getItemCount(): Int {
        return itemPict.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.pictures_img)
    }
}
