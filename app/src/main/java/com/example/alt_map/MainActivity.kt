package com.example.alt_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val OPEN_GALLERY = 1

    private val mainFrameLayout: FrameLayout by lazy {
        findViewById(R.id.mainFrameLayout)//
    }

    private val navigation: BottomNavigationView by lazy {
        findViewById(R.id.navigation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(mainFrameLayout.id, Map_fragment()).commit()
        navigation.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.navigation_map -> Map_fragment()
                    R.id.navigation_weather -> WeatherFragment()
                    else -> SettingsFragment()
                }
            )
            true
        }
    }


    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(mainFrameLayout.id, fragment).commit()
    }
}