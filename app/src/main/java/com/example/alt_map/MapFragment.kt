package com.example.alt_map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(){

    private lateinit var mMap: GoogleMap
    lateinit var mainFrameLayout : FrameLayout
    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(35.662530, 128.413830)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mMap = googleMap
        val G = LatLng(35.662397, 128.413894)

        mMap.addMarker(
            MarkerOptions()
                .position(G)
                .title("Marker in Sydney")
        )

        mMap.setOnMarkerClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        Log.d("상태","MapFragment_onCreateView")
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("상태","MapFragment_onViewCreated")
        val main = (activity as MainActivity) //MainActivity에서 사용하는 replaceFragment함수 사용
        mainFrameLayout = main.findViewById(R.id.mainFrameLayout)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


    }

}