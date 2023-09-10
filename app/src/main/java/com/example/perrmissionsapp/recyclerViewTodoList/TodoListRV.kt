package com.example.perrmissionsapp.recyclerViewTodoList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.perrmissionsapp.R

class TodoListRV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_rv)

        val rvTodoList = findViewById<RecyclerView>(R.id.rvTodoList)
        val userInput = findViewById<EditText>(R.id.userInput)
        val addButton = findViewById<Button>(R.id.button2)

//        var input : String
//        var arrayList : ArrayList<Todo>
//        arrayList = ArrayList()

        var todoList = mutableListOf(
            Todo("This is first one", false),
            Todo("This is second item", false)
        )

        val adapter = TodoAdapter(todoList)
        rvTodoList.adapter = adapter
        rvTodoList.layoutManager = LinearLayoutManager(this)



        addButton.setOnClickListener {
//            arrayList.add(Todo(userInput.text.toString(), false))

            val title = userInput.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)

        }



    }
}