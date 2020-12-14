package com.testapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.best_seller_item.view.*
import kotlinx.android.synthetic.main.carousel_item.view.image


class BestSellersAdapter(private var dataList: List<BestSellers>, private val context: Context) :
    RecyclerView.Adapter<BestSellersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.best_seller_item, parent, false)
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

        holder.itemView.title.text = dataModel.title
        holder.itemView.author.text = dataModel.author
        holder.itemView.price.text = "${dataModel.price.toString()} €"
        holder.itemView.score.text =
            "${dataModel.rate.score.toString()} (${dataModel.rate.amount.toString()})"

        holder.itemView.setOnClickListener {
            val activityClass = BookActivity::class.java
            val activity = Intent(context, activityClass)
            activity.putExtra("title", holder.itemView.title.text.toString())
            activity.putExtra("author", holder.itemView.author.text.toString())
            activity.putExtra("price", holder.itemView.title.text.toString())
            activity.putExtra("score", holder.itemView.score.text.toString())
            activity.putExtra("image", holder.itemView.image.drawable.toBitmap())

            startActivity(context, activity, null)
        }
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {


    }


}