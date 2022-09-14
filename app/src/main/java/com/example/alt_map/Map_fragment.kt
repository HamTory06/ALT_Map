package com.example.alt_map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class Map_fragment : Fragment() {

    lateinit var mainFrameLayout : FrameLayout
    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(35.6632493, 128.4141269)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val main = (activity as MainActivity) //MainActivity에서 사용하는 replaceFragment함수 사용
        mainFrameLayout = main.findViewById(R.id.mainFrameLayout)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        val button = view.findViewById<Button>(R.id.map_button)
        button.setOnClickListener{
            val random = (0..2).random() //랜덤으로 버튼 누르면 3개프레그먼트중 1개 보여줌 (Rain,Cloud,Sunny)
            main.replaceFragment(
                when(random){
                    0 -> Rain_fragment()
                    1 -> Cloud_fragment()
                    else -> Sunny_fragment()
                }
            )
            true
        }
    }

}