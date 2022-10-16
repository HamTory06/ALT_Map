package com.example.alt_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Sunny_fragment : Fragment() {
    private var itemlist: ArrayList<SunnyData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: SunnyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_sunny, container, false)




        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.rcv_sunny)
        recyclerView.setHasFixedSize(true)

        mAdapter = SunnyAdapter(requireContext())

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator();
        recyclerView.adapter = mAdapter

        addData()
    }

    private fun addData() {
        //축구, 산책, 외출, 야외코딩, 등산, 자전거 타기, 농구
        mAdapter.data.add(SunnyData(R.drawable.img_7,"자전거 타기", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(SunnyData(R.drawable.img_1,"외출", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(SunnyData(R.drawable.img_6,"등산", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(SunnyData(R.drawable.img_5,"야외코딩", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(SunnyData(R.drawable.img,"축구", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(SunnyData(R.drawable.img_3,"농구", 37.54892296550104, 126.99089033876304))
    }
}