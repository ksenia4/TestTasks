package com.testapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.carousel_item.view.*


class SimilarAdapter(private var dataList: List<Similar>, private val context: Context) :
    RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.similar_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        Glide.with(context)
            .load(dataModel.image.toString())
            .into(holder.itemView.image)
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var image: ImageView

        init {
            image = itemLayoutView.findViewById(R.id.image)
        }

    }

}