package com.example.alt_map

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CloudAdapter(val context: Context) : RecyclerView.Adapter<CloudAdapter.Holder>() {

    var data = mutableListOf<CloudData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        Log.d("상태","CloudAdapter_onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.cloud_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Log.d("상태","CloudAdapter_onBindViewHolder")
        val cloudData = data[position]
        holder.bind(cloudData)
    }

    override fun getItemCount(): Int {
        Log.d("상태","CloudAdapter_getItemCount")
        return data.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.cloud_activity_text)
        val img = itemView.findViewById<ImageView>(R.id.profile_img)
        fun bind(cloudData: CloudData) {
            name.text = cloudData.name
            img.setImageResource(cloudData.profile)
            img.clipToOutline = true
        }
    }
}