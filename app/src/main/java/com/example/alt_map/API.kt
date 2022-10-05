package com.example.alt_map

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("weather/")
    fun get(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appid") appid: String): Call<WeatherData>
}