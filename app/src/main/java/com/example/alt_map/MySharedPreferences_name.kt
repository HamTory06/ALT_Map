package com.example.alt_map

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences_name(context:Context) {

    private val Name = "Pref"
    private val Key = "myEditText"
    private val Prefs: SharedPreferences = context.getSharedPreferences(Name,0)

    var myEditText: String?
        get() = Prefs.getString(Key,"")
        set(value) = Prefs.edit().putString(Key, value).apply()

}