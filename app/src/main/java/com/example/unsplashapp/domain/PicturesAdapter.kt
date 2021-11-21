package com.example.unsplashapp.domain

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.unsplashapp.R
import com.example.unsplashapp.data.Result
import com.example.unsplashapp.presentor.view.OrdersCallback

class PicturesAdapter(private val callback: OrdersCallback) :
    RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {

    var itemPict = mutableListOf<Result>()

    fun setData(list: MutableList<Result>) {
        itemPict.addAll(list)
        notifyDataSetChanged()
    }

    fun replace(result: List<Result>) {
        itemPict.addAll(result)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_item, parent, false)
        val holder = ViewHolder(itemView)


        holder.image.setOnClickListener {
            Log.e("ERROR PIC", itemPict[holder.adapterPosition].urls.regular)
            callback.openFragment(itemPict[holder.adapterPosition])

        }

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(itemPict[position].urls.regular).into(holder.image)
    }

    override fun getItemCount(): Int {
        return itemPict.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.pictures_img)
    }
}
