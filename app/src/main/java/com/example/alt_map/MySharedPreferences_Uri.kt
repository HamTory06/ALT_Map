package com.example.alt_map

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences_Uri(context: Context) {

    private val name = "Prefs"
    private val key = "myEditTexts"
    private val prefs: SharedPreferences = context.getSharedPreferences(name,0)


    var myUri: String?
        get() = prefs.getString(key,"")
        set(value) = prefs.edit().putString(key, value).apply()
}