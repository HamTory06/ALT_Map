package com.example.alt_map

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context:Context) {

    private val Name = "Pref"
    private val nameKey = "myEditText"
    private val uriKey = "myEditTexts"
    private val Prefs: SharedPreferences = context.getSharedPreferences(Name,0)

    var myEditText: String?
        get() = Prefs.getString(nameKey,"")
        set(value) = Prefs.edit().putString(nameKey, value).apply()

    var myUri: String?
        get() = Prefs.getString(uriKey, "")
        set(value) = Prefs.edit().putString(uriKey, value).apply()

}