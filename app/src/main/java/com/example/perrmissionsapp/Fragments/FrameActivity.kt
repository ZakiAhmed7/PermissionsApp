package com.example.perrmissionsapp.Fragments

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.perrmissionsapp.R

class FrameActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        val btnFirst = findViewById<Button>(R.id.btnFirst)
        val btnSecond = findViewById<Button>(R.id.btnSecond)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, firstFragment)
            commit()
        }

        btnFirst.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, firstFragment)
                addToBackStack(null) // Adding fragment to stack.
                commit()
            }
        }

        btnSecond.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, secondFragment)
                addToBackStack(null) // Adding fragment to stack.
                commit()
            }
        }

    }
}