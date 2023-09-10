package com.example.perrmissionsapp.recyclerViewTodoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.perrmissionsapp.R

class TodoAdapter(var todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder> () {

    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_todo_item, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
//            tvItem.text = todos[position].title
//            cbDone.isChecked = todos[position].isChecked
        }
    }
}