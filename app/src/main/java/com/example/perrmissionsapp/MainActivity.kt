package com.example.perrmissionsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.perrmissionsapp.recyclerViewTodoList.TodoListRV

class MainActivity : AppCompatActivity() {

    private lateinit var permissionLauncher : ActivityResultLauncher<Array<String>>
    private var isLocationPermissionGranted = false
    private var isStoragePermissionGranted = false
    private var isPhonePermissionGranted = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val btnDialog = findViewById<Button>(R.id.btnDialog)

        button.setOnClickListener {
//        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions)) {
        }
        val options = arrayOf("RecyclerView 1", "RecyclerView 2", "RecyclerView 3")
        btnDialog.setOnClickListener{
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Which Recycler view you want to view?")
                .setSingleChoiceItems(options, 0) {_, selectedPosition ->
                    Toast.makeText(this@MainActivity, "you have selected ${options[selectedPosition]}", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("select") { _, selectedOption ->
                    if (selectedOption == 0)
                        Intent(this, TodoListRV::class.java).also {
                            startActivity(it)
                        }
                        else if (selectedOption == 1)

                            else if(selectedOption == 2)
                                else
                        Toast.makeText(this@MainActivity, "Something went wrong select again", Toast.LENGTH_SHORT).show()
                }.create()
        }
    }




//    private fun handlingPermissions() {
//        isLocationPermissionGranted =
//            ContextCompat.checkSelfPermission(this, ) ==
//                    PackageManager.PERMISSION_GRANTED
//    }

}