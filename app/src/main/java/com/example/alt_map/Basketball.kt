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


class Basketball : Fragment() {
    private var itemList: ArrayList<BasketballData> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: BasketballAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_basketball, container, false)
        recyclerView = v.findViewById(rcv_basket)
        recyclerView.setHasFixedSize(true)

        mAdapter = BasketballAdapter(requireContext())

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
        mAdapter.data.add(BasketballData(R.drawable.basket_4640,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4639,))
        mAdapter.data.add(BasketballData(R.drawable.basket_0015,))
        mAdapter.data.add(BasketballData(R.drawable.basket_0020,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4646,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4645,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4623,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4648,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4650,))
        mAdapter.data.add(BasketballData(R.drawable.basket_4649,))
    }
}