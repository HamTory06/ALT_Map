package com.example.alt_map

import android.app.Application

class App : Application(){
    companion object{
        lateinit var prefs : MySharedPreferences_Uri
        lateinit var Prefs : MySharedPreferences_name
    }

    override fun onCreate() {
        Prefs = MySharedPreferences_name(applicationContext)
        prefs = MySharedPreferences_Uri(applicationContext)
        super.onCreate()

    }
}