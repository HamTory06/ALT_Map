package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainbuildingAdapter(val context: Context) : RecyclerView.Adapter<MainbuildingAdapter.Holder>() {

    var data = mutableListOf<MainbuildingData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.mainbuilding_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val mainbuildingData = data[position]
        holder.bind(mainbuildingData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.mainbu_text)
        val img = itemView.findViewById<ImageView>(R.id.mainbu_img)
        fun bind(mainbuildingData: MainbuildingData) {
            img.setImageResource(mainbuildingData.profile)
            img.clipToOutline = true
        }
    }
}