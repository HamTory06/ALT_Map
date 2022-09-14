package com.example.alt_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val mainFrameLayout: FrameLayout by lazy {
        findViewById(R.id.mainFrameLayout)
    }

    private val navigation: BottomNavigationView by lazy {
        findViewById(R.id.navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(mainFrameLayout.id, Map_fragment()).commit()

//        val weather = Retrofit.Builder()
//            .baseUrl("http://api.openweathermap.org/data/2.5/weather?lat=35.6632493&lon=128.4141269&APPID=814ea831f9adecdf0164966dbecab1ce")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

        navigation.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.navigation_map -> Map_fragment()
                    R.id.navigation_weather -> Weather_fragment()
                    else -> Settings_fragment()
                }
            )
            true
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(mainFrameLayout.id, fragment).commit()
    }
}