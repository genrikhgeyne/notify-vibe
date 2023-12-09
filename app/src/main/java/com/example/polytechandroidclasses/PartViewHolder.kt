package com.example.polytechandroidclasses

import androidx.recyclerview.widget.RecyclerView
import com.example.polytechandroidclasses.databinding.TaskItemBinding

class PartViewHolder(private val binding: TaskItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(task: TaskData, clickListener: (TaskData) -> Unit) {
        binding.taskText.text = task.taskText
        binding.taskCheckBox.isChecked = task.taskStatus
        binding.root.setOnClickListener { clickListener(task) }
    }
}