package com.iniudin.githubuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udindev.warta.R
import com.udindev.warta.model.ArticlesItem
import kotlinx.android.synthetic.main.item_news.view.*


class TopNewsAdapter(private val list: List<ArticlesItem?>?) : RecyclerView.Adapter<TopNewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
                .load(list?.get(position)?.urlToImage)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(holder.itemView.image_news)

        holder.itemView.txt_title.text = list?.get(position)?.title
        holder.itemView.txt_time.text = list?.get(position)?.publishedAt
    }
}