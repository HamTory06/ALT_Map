package com.example.alt_map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(){

    private lateinit var gym: GoogleMap
    private lateinit var backbuilding: GoogleMap
    private lateinit var Mainbuilding: GoogleMap
    private lateinit var soccer: GoogleMap
    private lateinit var dormitory: GoogleMap
    private lateinit var basketball: GoogleMap
    lateinit var mainFrameLayout : FrameLayout
    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(35.662530, 128.413830)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        gym = googleMap
        backbuilding = googleMap
        Mainbuilding = googleMap
        soccer = googleMap
        dormitory = googleMap
        basketball = googleMap
        val A = LatLng(35.661847, 128.413808)//헬스
        val B = LatLng(35.663300, 128.413863)//후관
        val C = LatLng(35.662919, 128.413733)//본관
        val D = LatLng(35.662468,128.413431)//기숙사
        val E = LatLng(35.662601,128.413876)//축구
        val F = LatLng(35.663032,128.413739)//농구



        gym.addMarker(
            MarkerOptions()
                .position(A)
                .title("헬스")
        )

        gym.setOnMarkerClickListener {
            //requireFragmentManager().beginTransaction().replace(R.id.rcv_gym2, Gym())
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true

        }
        //--------------------------------------------------------------------
        backbuilding.addMarker(
            MarkerOptions()
                .position(B)
                .title("후관")
        )

        backbuilding.setOnMarkerClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true
        }
        //--------------------------------------------------------------------
        Mainbuilding.addMarker(
            MarkerOptions()
                .position(C)
                .title("본관")
        )

        Mainbuilding.setOnMarkerClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true
        }
        //--------------------------------------------------------------------
        soccer.addMarker(
            MarkerOptions()
                .position(E)
                .title("축구")
        )

        soccer.setOnMarkerClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true
        }
        //--------------------------------------------------------------------
        dormitory.addMarker(
            MarkerOptions()
                .position(D)
                .title("기숙사")
        )

        dormitory.setOnMarkerClickListener {
            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            return@setOnMarkerClickListener true
        }
//        //--------------------------------------------------------------------
        basketball.addMarker(
            MarkerOptions()
                .position(F)
                .title("농구")
        )

        basketball.setOnMarkerClickListener {
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