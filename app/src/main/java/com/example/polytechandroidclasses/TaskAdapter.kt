package com.example.polytechandroidclasses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.polytechandroidclasses.databinding.TaskItemBinding

class TaskAdapter(private var taskItemList: List<TaskData>, private val clickListener: (TaskData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = TaskItemBinding.inflate(inflater, parent, false)
        return PartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(taskItemList[position], clickListener)
    }

    override fun getItemCount() = taskItemList.size
}