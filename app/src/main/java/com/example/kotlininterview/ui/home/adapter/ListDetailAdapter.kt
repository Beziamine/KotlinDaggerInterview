package com.example.kotlininterview.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlininterview.R
import com.example.kotlininterview.model.App_images

class ListDetailAdapter(private val context: Context?, private val list: MutableList<App_images>,
                        fragment: Fragment
): RecyclerView.Adapter<ListDetailAdapter.DetailViewHolder>() {


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        var detail = list[position]

        Glide.with(context!!)
            .load(detail.image_url)
            .centerCrop()
            .into(holder.imageApp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.model_app_images, parent, false)
        return ListDetailAdapter.DetailViewHolder(itemView)
    }



    class DetailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageApp = itemView.findViewById<ImageView>(R.id.image_app)

    }
}