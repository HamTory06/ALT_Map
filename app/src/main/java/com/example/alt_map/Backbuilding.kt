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


class Backbuilding : Fragment() {
    private var itemList: ArrayList<BackbuildingData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: BackbuildingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_backbuilding, container, false)
        recyclerView = v.findViewById(rcv_back)
        recyclerView.setHasFixedSize(true)

        mAdapter = BackbuildingAdapter(requireContext())

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
        mAdapter.data.add(BackbuildingData(R.drawable.mop,))
        mAdapter.data.add(BackbuildingData(R.drawable.group2,))
        mAdapter.data.add(BackbuildingData(R.drawable.group,))
        mAdapter.data.add(BackbuildingData(R.drawable.class3,))
        mAdapter.data.add(BackbuildingData(R.drawable.class3_2,))
        mAdapter.data.add(BackbuildingData(R.drawable.class_3_3,))
        mAdapter.data.add(BackbuildingData(R.drawable.oke,))
        mAdapter.data.add(BackbuildingData(R.drawable.oke_1,))
        mAdapter.data.add(BackbuildingData(R.drawable.oke_2,))
    }
}