package com.iniudin.githubuserapp.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udindev.warta.R
import com.udindev.warta.fragment.DetailNewsFragment
import com.udindev.warta.model.ArticlesItem
import kotlinx.android.synthetic.main.item_menu_sport.view.*


class SportNewsAdapter(private val list: List<ArticlesItem?>?) :
    RecyclerView.Adapter<SportNewsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_menu_sport, parent, false)
    )

    override fun getItemCount(): Int = list?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
            .load(list?.get(position)?.urlToImage)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(holder.itemView.image_news)
        holder.itemView.txt_title.text = list?.get(position)?.title


        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(DetailNewsFragment.EXTRA_URL, list?.get(position)?.url)
            val fragment = DetailNewsFragment()
            fragment.arguments = bundle

            setFragment(fragment, holder.itemView.context)
        }
    }

    private fun setFragment(fragment: DetailNewsFragment, context: Context?) {
        (context as AppCompatActivity).supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment, "Adapter")
            .addToBackStack(null)
            .commit()
    }

}