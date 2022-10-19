package com.example.alt_map

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherFragment : Fragment() {

    var weather : String? = null
    private lateinit var cloud: ImageView
    private lateinit var rain: ImageView
    private lateinit var sunny: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireActivity().getSharedPreferences("Name", Activity.MODE_PRIVATE)


        cloud = view.findViewById<ImageView>(R.id.cloud_btn)
        cloud.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.sub_frame_layout, Cloud_fragment()).commit()
            settingclick(cloud)
        }

        rain = view.findViewById<ImageView>(R.id.rain_btn)
        rain.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.sub_frame_layout, Rain_fragment()).commit()
            settingclick(rain)
        }

        sunny = view.findViewById<ImageView>(R.id.sunny_btn)
        sunny.setOnClickListener {
            requireFragmentManager().beginTransaction().replace(R.id.sub_frame_layout, Sunny_fragment()).commit()
            settingclick(sunny)
        }

        var BaseUrl = "https://api.openweathermap.org/data/2.5/"


        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(API::class.java)
        val call = service.get(35.6632493.toLong(), 128.4141269.toLong(),"814ea831f9adecdf0164966dbecab1ce")
        if (weather == null) {
            Log.d("retrofit","$weather")
            call.enqueue(object : Callback<WeatherData> {
                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    Log.d("qwer", "result :" + t.message)
                }

                override fun onResponse(
                    call: Call<WeatherData>,
                    response: Response<WeatherData>
                ) {
                    val weatherResponse = response.body()
                    weather = weatherResponse!!.weather[0].main
                    App.Prefs.weatherdata = weather
                    when (weather) {
                        "Thunderstorm", "Drizzle", "Rain", "Snow" -> {
                            requireFragmentManager().beginTransaction()
                                .replace(R.id.sub_frame_layout, Rain_fragment()).commit()
                            settingclick(rain)
                        }
                        "Atmosphere", "Clouds" -> {
                            requireFragmentManager().beginTransaction()
                                .replace(R.id.sub_frame_layout, Cloud_fragment()).commit()
                            settingclick(cloud)
                        }
                        "Clear" -> {
                            requireFragmentManager().beginTransaction()
                                .replace(R.id.sub_frame_layout, Sunny_fragment()).commit()
                            settingclick(sunny)
                        }
                    }
                }
            })
        }
        else{
            Log.d("retrofit","$weather")
            when (weather) {
                "Thunderstorm", "Drizzle", "Rain", "Snow" -> {
                    requireFragmentManager().beginTransaction()
                        .replace(R.id.sub_frame_layout, Rain_fragment()).commit()
                    settingclick(rain)
                }
                "Atmosphere", "Clouds" -> {
                    requireFragmentManager().beginTransaction()
                        .replace(R.id.sub_frame_layout, Cloud_fragment()).commit()
                    settingclick(cloud)
                }
                "Clear" -> {
                    requireFragmentManager().beginTransaction()
                        .replace(R.id.sub_frame_layout, Sunny_fragment()).commit()
                    settingclick(sunny)
                }
            }
        }
    }

    private fun settingclick(view: View) {
        when(view) {
            sunny -> {
                sunny.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_on)
                cloud.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                rain.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                sunny.setColorFilter(Color.parseColor("#6B37D8"))
                cloud.setColorFilter(Color.parseColor("#FFFFFF"))
                rain.setColorFilter(Color.parseColor("#FFFFFF"))
            }
            cloud -> {
                cloud.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_on)
                sunny.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                rain.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                cloud.setColorFilter(Color.parseColor("#6B37D8"))
                sunny.setColorFilter(Color.parseColor("#FFFFFF"))
                rain.setColorFilter(Color.parseColor("#FFFFFF"))
            }
            rain -> {
                rain.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_on)
                cloud.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                sunny.background = ContextCompat.getDrawable(requireContext(), R.drawable.click_off)
                rain.setColorFilter(Color.parseColor("#6B37D8"))
                cloud.setColorFilter(Color.parseColor("#FFFFFF"))
                sunny.setColorFilter(Color.parseColor("#FFFFFF"))
            }
        }
    }
}