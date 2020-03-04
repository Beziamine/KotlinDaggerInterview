package com.example.kotlininterview.ui.home.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlininterview.R
import com.example.kotlininterview.model.Model

class ListAdapter(private val context: Context?, private val list: MutableList<Model>,
                  fragment: Fragment
): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    private val listener: ListAdapter.onItemClickListener

    init {
        this.listener = fragment as ListAdapter.onItemClickListener
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var post = list[position]

        holder.appName!!.setText(post.name)
        holder.appDescription!!.setText(post.short_desc)

        Glide.with(context!!)
            .load(post.app_icon_url)
            .centerCrop()
            .into(holder.appIcon)

        holder.itemView.setOnClickListener {
            listener.itemDetail(post.app_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.model_item, parent, false)
        return ListAdapter.ListViewHolder(itemView)
    }



    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val appIcon = itemView.findViewById<ImageView>(R.id.app_icon)
        val appName = itemView.findViewById<TextView>(R.id.app_name)
        val appDescription = itemView.findViewById<TextView>(R.id.app_description)

    }

    interface onItemClickListener {
        fun itemDetail(postId : String)
    }
}