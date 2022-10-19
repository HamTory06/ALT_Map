package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SoccerAdapter(val context: Context) : RecyclerView.Adapter<SoccerAdapter.Holder>() {

    var data = mutableListOf<SoccerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.soccer_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val soccerData = data[position]
        holder.bind(soccerData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.soccer_text)
        val img = itemView.findViewById<ImageView>(R.id.soccer_img)
        fun bind(soccerData: SoccerData) {
            img.setImageResource(soccerData.profile)
            img.clipToOutline = true
        }
    }
}