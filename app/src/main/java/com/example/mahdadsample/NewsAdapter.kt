package com.example.mahdadsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val context: Context) :
    RecyclerView.Adapter<NewsAdapter.NewsVH>() {

    override fun getItemCount(): Int {
        return 100
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): NewsVH {
        return NewsVH(
            LayoutInflater.from(context)
                .inflate(R.layout.news_row, parent, false)
        )
    }

    override fun onBindViewHolder(@NonNull holder: NewsVH, position: Int) {
        holder.newsImage.setImageResource(R.mipmap.ic_launcher)
        holder.newsText.text = "Mahdaad is learning android!!!"
        holder.parent.setOnClickListener {
            Toast.makeText(
                context, "${position} is clicked",
                Toast.LENGTH_LONG
            )
                .show()
        }
    }

    class NewsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parent: ViewGroup = itemView.findViewById(R.id.parentNews)
        val newsImage: ImageView = itemView.findViewById(R.id.ivNews)
        val newsText: TextView = itemView.findViewById(R.id.tvNews)
    }

}