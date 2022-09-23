package com.example.alt_map

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class SettingsFragment : Fragment() {
    private val OPEN_GALLERY = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save = requireView().findViewById<Button>(R.id.save)//save 버튼 findViewById
        val name = requireView().findViewById<EditText>(R.id.name)//name 들어가는 EditText
        val imageView = requireView().findViewById<ImageView>(R.id.circleImageView)
        Glide.with(requireContext()).load(App.prefs.myUri).circleCrop().into(imageView)
        name.setText(App.Prefs.myEditText)
        save.setOnClickListener {
            App.Prefs.myEditText = name.text.toString()
            Log.d("(APP)TAG", App.Prefs.myEditText!!)
//            Log.d("(name)TAG", name.text.toString())
//            if (!(App.Prefs.myEditText.isNullOrBlank()))
//                Log.d("(APP)TAG", App.Prefs.myEditText!!)
        }
        val gallery = requireView().findViewById<Button>(R.id.gallery)
        gallery.setOnClickListener {
            openGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = requireView().findViewById<ImageView>(R.id.circleImageView)
        val save = requireView().findViewById<Button>(R.id.save)//save 버튼 findViewById
        Glide.with(requireContext()).load(App.prefs.myUri).circleCrop().into(imageView)
        if (resultCode == Activity.RESULT_OK) { //만약에 정상적으로 코드가 실행 됬다면
            if (requestCode == OPEN_GALLERY) { // 갤러리가 켜졌다면

                var currentImageUrl: Uri? = data?.data
                Log.d("TAGTAG", currentImageUrl.toString())
                save.setOnClickListener{
                    App.prefs.myUri = currentImageUrl.toString() // SharedPreferences에 String로 변형하여 저장

                    val imageView = requireView().findViewById<ImageView>(R.id.circleImageView)
                    Glide.with(requireContext()).load(App.prefs.myUri).circleCrop().into(imageView)
                    Log.d("TAG(prefs)", App.prefs.myUri.toString())
                }
            }
        } else { // 코드가 정상적으로 실행 되지 않았다면
            Log.d("에러", "something wrong")
        }
    }

    private fun openGallery() {
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.setType("image/*")
        startActivityForResult(intent, OPEN_GALLERY)
    }
}
