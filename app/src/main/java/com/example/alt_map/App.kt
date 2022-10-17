package com.example.alt_map

import android.app.Application

class App : Application(){
    companion object{
        lateinit var Prefs : MySharedPreferences
    }

    override fun onCreate() {
        Prefs = MySharedPreferences(applicationContext)
        super.onCreate()
    }
}