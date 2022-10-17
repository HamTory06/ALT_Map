package com.example.alt_map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Cloud_fragment : Fragment() {
    private var itemList: ArrayList<CloudData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: CloudAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_cloud, container, false)
        recyclerView = v.findViewById(R.id.rcv_weather)
        recyclerView.setHasFixedSize(true)

        mAdapter = CloudAdapter(requireContext())

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator();
        recyclerView.adapter = mAdapter

        addData()

        return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun addData() {
        mAdapter.data.add(CloudData("구르르름", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(CloudData("힘드러", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(CloudData("난 여기랑 안맞나바", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(CloudData("개발이 머야", 37.54892296550104, 126.99089033876304))
        mAdapter.data.add(CloudData("울고싶다", 37.54892296550104, 126.99089033876304))
    }
}