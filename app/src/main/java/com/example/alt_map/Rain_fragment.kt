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



class Rain_fragment : Fragment() {
    private var itemlist: ArrayList<RainData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: RainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_rain, container, false)




        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = requireView().findViewById(R.id.rain_rcv_weather)
        recyclerView.setHasFixedSize(true)

        mAdapter = RainAdapter(requireContext())

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator();
        recyclerView.adapter = mAdapter

        addData()
    }

    private fun addData() {
        //실내 코딩, 카공, 강당 배드민턴, 탁구, 헬스
        mAdapter.data.add(RainData(R.drawable.img_2,"실내코딩", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(RainData(R.drawable.img_8,"카공", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(RainData(R.drawable.img_9,"배드민턴", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(RainData(R.drawable.img_10,"탁구", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(RainData(R.drawable.img_4,"헬스", 37.54892296550104, 126.99089033876304))
    }
}