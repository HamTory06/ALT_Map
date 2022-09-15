package com.example.alt_map

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

class Settings_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = requireView().findViewById<EditText>(R.id.name)
        val save = requireView().findViewById<Button>(R.id.save)
        name.setText(App.prefs.myEditText)
        if(!(App.prefs.myEditText.isNullOrBlank()))
            Log.d("TAG", App.prefs.myEditText!!)

        save.setOnClickListener{
            App.prefs.myEditText = name.text.toString()
        }
    }
}