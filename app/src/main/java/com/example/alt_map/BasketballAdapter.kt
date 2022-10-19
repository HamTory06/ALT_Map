package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketballAdapter(val context: Context) : RecyclerView.Adapter<BasketballAdapter.Holder>() {

    var data = mutableListOf<BasketballData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.basketball_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val basketballData = data[position]
        holder.bind(basketballData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.basketball_text)
        val img = itemView.findViewById<ImageView>(R.id.basketball_img)
        fun bind(basketballData: BasketballData) {
            img.setImageResource(basketballData.profile)
            img.clipToOutline = true
        }
    }
}