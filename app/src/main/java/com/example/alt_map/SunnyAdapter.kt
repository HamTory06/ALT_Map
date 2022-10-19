package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SunnyAdapter(val context: Context) : RecyclerView.Adapter<SunnyAdapter.Holder>() {

    var data = mutableListOf<SunnyData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.sunny_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val sunnyData = data[position]
        holder.bind(sunnyData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.sunny_activity_text)
        val img = itemView.findViewById<ImageView>(R.id.profile_img)
        fun bind(sunnyData: SunnyData) {
            name.text = sunnyData.name
            img.setImageResource(sunnyData.profile)
            img.clipToOutline = true
        }
    }
}