package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BackbuildingAdapter(val context: Context) : RecyclerView.Adapter<BackbuildingAdapter.Holder>() {

    var data = mutableListOf<BackbuildingData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.backbuilding_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val backbuildingData = data[position]
        holder.bind(backbuildingData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.backbuilding_text)
        val img = itemView.findViewById<ImageView>(R.id.backbuilding_img)
        fun bind(backbuildingData: BackbuildingData) {
            img.setImageResource(backbuildingData.profile)
            img.clipToOutline = true
        }
    }
}