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
import com.example.alt_map.R.id.rcv_gym
import com.example.alt_map.R.id.rcv_weather


class Gym : Fragment() {
    private var itemList: ArrayList<GymData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: GymAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_gym, container, false)
        recyclerView = v.findViewById(rcv_gym)
        recyclerView.setHasFixedSize(true)

        mAdapter = GymAdapter(requireContext())

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
        mAdapter.data.add(GymData(R.drawable.gym1,))
        mAdapter.data.add(GymData(R.drawable.gym2,))
        mAdapter.data.add(GymData(R.drawable.gym3,))
        mAdapter.data.add(GymData(R.drawable.gym4,))
        mAdapter.data.add(GymData(R.drawable.gym5,))
        mAdapter.data.add(GymData(R.drawable.gymgong1,))
        mAdapter.data.add(GymData(R.drawable.gymgong2,))
        mAdapter.data.add(GymData(R.drawable.gymrun,))
        mAdapter.data.add(GymData(R.drawable.gymtt,))
    }
}