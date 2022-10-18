package com.example.alt_map

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val OPEN_GALLERY = 1

    private val mainFrameLayout: FrameLayout by lazy {
        findViewById(R.id.mainFrameLayout)
    }

    private val navigation: BottomNavigationView by lazy {
        findViewById(R.id.navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("상태","MainActivity_onCreate")
        supportFragmentManager.beginTransaction().add(mainFrameLayout.id, MapFragment()).commit()
        navigation.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.navigation_map -> MapFragment()
                    R.id.navigation_weather -> WeatherFragment()
                    else -> SettingsFragment()
                }
            )
            true
        }
    }

    override fun onBackPressed() {
        Log.d("상태","MainActivity_onBackPressed")
//        super.onBackPressed()
        for(fragment: Fragment in supportFragmentManager.fragments) {
            if (fragment.isVisible) {
                if(fragment is Cloud_fragment || fragment is Sunny_fragment || fragment is Rain_fragment) {
                    replaceFragment(WeatherFragment())
                }
                if(fragment is WeatherFragment || fragment is MapFragment || fragment is SettingsFragment) {
                    super.onBackPressed()
                }
            }
        }
    }


    fun replaceFragment(fragment: Fragment) {
        Log.d("상태","MainActivity_replaceFragment")
        supportFragmentManager.beginTransaction().replace(mainFrameLayout.id, fragment).commit()
    }
}