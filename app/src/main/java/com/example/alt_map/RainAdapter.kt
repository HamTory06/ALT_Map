package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RainAdapter(val context: Context) : RecyclerView.Adapter<RainAdapter.Holder>() {

    var data = mutableListOf<RainData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.rain_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val rainData = data[position]
        holder.bind(rainData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.rain_activity_text)
        val img = itemView.findViewById<ImageView>(R.id.profile_img)
        fun bind(rainData: RainData) {
            name.text = rainData.name
            img.setImageResource(rainData.profile)
            img.clipToOutline = true
        }
    }
}