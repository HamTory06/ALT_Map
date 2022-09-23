package com.example.alt_map

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
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
import java.lang.Exception

class SettingsFragment : Fragment() {
    lateinit var  imageView : ImageView
    private val OPEN_GALLERY = 1
    private var resolver = requireActivity().contentResolver.toString()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save = requireView().findViewById<Button>(R.id.save)
        val name = requireView().findViewById<EditText>(R.id.name)
        val imageView = requireView().findViewById<ImageView>(R.id.circleImageView)
        name.setText(App.prefs.myEditText)
        if(!(App.prefs.myEditText.isNullOrBlank()))
            Log.d("TAG", App.prefs.myEditText!!)

        save.setOnClickListener{
            App.prefs.myEditText = name.text.toString()
        }
        val gallery = requireView().findViewById<Button>(R.id.gallery)
        gallery.setOnClickListener{
            openGallery()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?,) {
        super.onActivityResult(requestCode, resultCode, data)
        imageView = requireView().findViewById(R.id.circleImageView)
        if(resultCode == Activity.RESULT_OK){ //만약에 정상적으로 코드가 실행 됬다면
            if (requestCode == OPEN_GALLERY){ // 갤러리가 켜졌다면

                var currentImageUrl : Uri? = data?.data

                try { //contentResolver
                    val bitmap = MediaStore.Images.Media.getContentUri(resolver,currentImageUrl)
                    imageView.setImageBitmap(bitmap)

                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }else{ // 코드가 정상적으로 실행 되지 않았다면
            Log.d("에러","something wrong")
        }
    }
    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }
}
