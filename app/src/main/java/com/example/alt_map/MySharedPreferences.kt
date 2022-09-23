package com.example.alt_map

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context:Context) {

    private val prefsFilename = "prefs"
    private val prefsKeyEdt = "myEditText"
    private val prefsfilename = "Prefs"
    private val prefskeyedt = "myedittext"
    private val prefs: SharedPreferences = context.getSharedPreferences(prefsFilename,0)

    var myEditText: String?
        get() = prefs.getString(prefsFilename,"")
        set(value) = prefs.edit().putString(prefsKeyEdt, value).apply()

    var myUri: String?
        get() = prefs.getString(prefsfilename,"")
        set(value) = prefs.edit().putString(prefskeyedt, value).apply()//
}