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


class Soccer : Fragment() {
    private var itemList: ArrayList<SoccerData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: SoccerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_soccer, container, false)
        recyclerView = v.findViewById(rcv_soccer)
        recyclerView.setHasFixedSize(true)

        mAdapter = SoccerAdapter(requireContext())

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
        mAdapter.data.add(SoccerData(R.drawable.soccer_4651,))
        mAdapter.data.add(SoccerData(R.drawable.soccer_4652))
        mAdapter.data.add(SoccerData(R.drawable.soccer_4673,))
        mAdapter.data.add(SoccerData(R.drawable.bsk,))

    }
}