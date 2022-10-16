package com.example.alt_map

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("weather/")
    fun get(@Query("lat") lat: Long, @Query("lon") lon: Long, @Query("appid") appid: String): Call<WeatherData>
}