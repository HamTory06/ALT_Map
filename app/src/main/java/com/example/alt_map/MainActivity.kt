package com.example.alt_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        supportFragmentManager.beginTransaction().add(mainFrameLayout.id, Map()).commit()

        navigation.setOnNavigationItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.navigation_map -> Map()
                    R.id.navigation_weather -> weather()
                    else -> settings()
                }
            )
            true
        }

//        val navController = findNavController(R.id.mainFrameLayout) // 네비게이션 정의 된 걸 가져옴
//        val main_fragment = findViewById<FrameLayout>(R.id.mainFrameLayout)
//        val main_nav = findViewById<BottomNavigationView>(R.id.navigation)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(mainFrameLayout.id, fragment).commit()
    }
}