package com.example.perrmissionsapp.ViewPager2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.perrmissionsapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class pagerMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager_main)

        val imagesList = listOf<Int>(
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8
        )

        val adapter = ViewPagerAdapter(imagesList)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

//        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        viewPager.beginFakeDrag()
//        viewPager.fakeDragBy(-10f)
//        viewPager.beginFakeDrag()

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()

        tabLayout.addOnTabSelectedListener( object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@pagerMainActivity, "selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@pagerMainActivity, "unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@pagerMainActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}