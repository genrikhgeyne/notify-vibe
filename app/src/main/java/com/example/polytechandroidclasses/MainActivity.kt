package com.example.polytechandroidclasses

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.polytechandroidclasses.databinding.ActivityMainBinding
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tasksRecycler.layoutManager = LinearLayoutManager(this)

        binding.tasksRecycler.setHasFixedSize(true)
        val testData = createTestData()

        binding.tasksRecycler.adapter = TaskAdapter(testData) { taskItem: TaskData ->
            taskItemClicked(
                taskItem
            )
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    private fun taskItemClicked(taskItem: TaskData) {
        taskItem.taskStatus = !taskItem.taskStatus

        binding.tasksRecycler.adapter?.notifyDataSetChanged()

        val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
        val progressText = findViewById<TextView>(R.id.textProgress)

        val step = 100.toFloat() / binding.tasksRecycler.adapter!!.itemCount

        circularProgressBar.apply {
            if (taskItem.taskStatus) {
                progressText.text = getString(
                    R.string.progress_text,
                    (progress + step).roundToInt()
                )
                setProgressWithAnimation(progress + step, 1000)
            } else {
                progressText.text = getString(
                    R.string.progress_text,
                    (progress - step).roundToInt()
                )
                setProgressWithAnimation(progress - step, 1000)
            }
        }


    }

    private fun createTestData(): List<TaskData> {
        val taskList = ArrayList<TaskData>()
        taskList.add(TaskData("Take medications"))
        taskList.add(TaskData("Water the flower"))
        taskList.add(TaskData("Wash dishes"))
        taskList.add(
            TaskData(
                "Take medications Take medications Take medications Take medications"
            )
        )
        taskList.add(TaskData("Water the flower"))
        taskList.add(TaskData("Wash dishes"))
        taskList.add(TaskData("Take medications"))
        taskList.add(TaskData("Water the flower"))
        taskList.add(TaskData("Wash dishes Wash dishes Wash dishes"))
        taskList.add(TaskData("Take medications"))
        taskList.add(TaskData("Water the flower"))
        taskList.add(TaskData("Wash dishes"))
        taskList.add(TaskData("Take medications"))
        taskList.add(TaskData("Water the flower"))
        taskList.add(TaskData("Wash dishes"))
        return taskList
    }
}