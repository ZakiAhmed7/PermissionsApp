package com.example.perrmissionsapp.SharedPreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.perrmissionsapp.R

class SharedPrefMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref_main)

        val eTUserName = findViewById<EditText>(R.id.eTUserName)
        val etPassword = findViewById<EditText>(R.id.eTPassword)
        val cbRememberMe = findViewById<CheckBox>(R.id.cbRememberMe)
        val btnFetch = findViewById<Button>(R.id.btnFetch)
        val btnSave = findViewById<Button>(R.id.btnSave)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            var userName = eTUserName.text.trim().toString()
            var password = etPassword.text.trim().toString()
            var rememberMe = cbRememberMe.isChecked


            editor.apply {
                putString("name", userName)
                putString("password", password)
                putBoolean("isRememberMe", rememberMe)
                apply()
            }
        }

        btnFetch.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val password = sharedPref.getString("password", null)
            val rememberMe = sharedPref.getBoolean("isRememberMe", false)

            eTUserName.setText(name)
            etPassword.setText(password)
            cbRememberMe.isChecked = rememberMe
        }
    }
}