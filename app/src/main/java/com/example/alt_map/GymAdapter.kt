package com.example.alt_map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GymAdapter(val context: Context) : RecyclerView.Adapter<GymAdapter.Holder>() {

    var data = mutableListOf<GymData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.gym_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val gymData = data[position]
        holder.bind(gymData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.gym_text)
        val img = itemView.findViewById<ImageView>(R.id.gym_img)
        fun bind(gymData: GymData) {
            img.setImageResource(gymData.profile)
            img.clipToOutline = true
        }
    }
}