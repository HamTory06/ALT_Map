package com.example.alt_map

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireActivity().getSharedPreferences("Name", Activity.MODE_PRIVATE)
        val w = requireView().findViewById<TextView>(R.id.w)


        var BaseUrl = "https://api.openweathermap.org/data/2.5/"

        val tv = view.findViewById<TextView>(R.id.w)

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(API::class.java)
        val call = service.get(35.6632493.toLong(), 128.4141269.toLong(),"814ea831f9adecdf0164966dbecab1ce")
        call.enqueue(object : Callback<CloudData> {
            override fun onFailure(call: Call<CloudData>, t: Throwable) {
                Log.d("MainActivity", "result :" + t.message)
//                Log.d("MainActivity","오류")
            }

            override fun onResponse(
                call: Call<CloudData>,
                response: Response<CloudData>
            ) {
                val weatherResponse = response.body()
                Log.d("MainActivity", "result: " + weatherResponse.toString())
                val stringBuilder =
                    "날씨: " + weatherResponse!!.name
                tv.text = stringBuilder
            }

        })
    }
}