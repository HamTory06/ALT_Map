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
import com.example.alt_map.R.id.*


class Mainbuilding : Fragment() {
    private var itemList: ArrayList<MainbuildingData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: MainbuildingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_mainbuilding, container, false)
        recyclerView = v.findViewById(rcv_mainbu)
        recyclerView.setHasFixedSize(true)

        mAdapter = MainbuildingAdapter(requireContext())

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
        mAdapter.data.add(MainbuildingData(R.drawable.main_4626,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4627,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4628,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4629,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4630,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4631,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4632,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4633,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4634,))
        mAdapter.data.add(MainbuildingData(R.drawable.main_4636,))
    }
}