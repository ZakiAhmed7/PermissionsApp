package com.example.perrmissionsapp.SlideableMenuwithNavBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.perrmissionsapp.R
import com.google.android.material.navigation.NavigationView

class SlideableMainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slidable_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navBarDMA = findViewById<NavigationView>(R.id.navBarDMA)
        navBarDMA.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuItem1 -> Toast.makeText(this, "item 1 selected", Toast.LENGTH_SHORT).show()
                R.id.menuItem2 -> Toast.makeText(this, "item 2 selected", Toast.LENGTH_SHORT).show()
                R.id.menuItem3 -> Toast.makeText(this, "item 3 selected", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}