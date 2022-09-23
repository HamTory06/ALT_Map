package com.example.alt_map

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

class SettingsFragment : Fragment() {

    private val OPEN_GALLERY = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save = requireView().findViewById<Button>(R.id.save)
        val name = requireView().findViewById<EditText>(R.id.name)
        name.setText(App.prefs.myEditText)
        if(!(App.prefs.myEditText.isNullOrBlank()))
            Log.d("TAG", App.prefs.myEditText!!)

        save.setOnClickListener{
            App.prefs.myEditText = name.text.toString()
        }
        val gallery = requireView().findViewById<Button>(R.id.gallery)
        val circularImageView = requireView().findViewById<ImageView>(R.id.circleImageView)
        gallery.setOnClickListener{
            openGallery()
        }
    }
    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }
}
