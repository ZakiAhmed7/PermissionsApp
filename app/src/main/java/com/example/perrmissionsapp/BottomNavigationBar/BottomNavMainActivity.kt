package com.example.perrmissionsapp.BottomNavigationBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.perrmissionsapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_main)

        val bottomFragHome = BottomFragHome()
        val bottomFragMessages = BottomFragMessages()
        val bottomFragProfile = BottomFragProfile()

        setCurrentFragment(bottomFragHome)

        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavBar)

        bottomNavBar.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menuHome -> setCurrentFragment(bottomFragHome)
                R.id.menuMessages -> setCurrentFragment(bottomFragMessages)
                R.id.menuProfile -> setCurrentFragment(bottomFragProfile)
            }
            true
        }

        bottomNavBar.getOrCreateBadge(R.id.menuMessages).apply {
            number = 10
            isVisible = true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navFrameLay, fragment)
            commit()
        }
    }
}