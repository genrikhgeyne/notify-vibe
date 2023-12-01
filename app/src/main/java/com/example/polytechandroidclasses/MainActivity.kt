package com.example.polytechandroidclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.polytechandroidclasses.databinding.ActivityMainBinding
import com.example.polytechandroidclasses.databinding.TaskItemBinding

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


//        val changeProgressButton = findViewById<Button>(R.id.buttonProgress)
//        val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
//        val progressText = findViewById<TextView>(R.id.textProgress)

//        changeProgressButton.setOnClickListener {
//            circularProgressBar.apply {
//                if (progress < 100f) {
//                    progressText.text = getString(
//                        R.string.progress_text,
//                        (progress + 20f).roundToInt()
//                    )
//                    setProgressWithAnimation(progress + 20f, 1000)
//                } else {
//                    setProgressWithAnimation(0f, 1000)
//                    progressText.text = getString(R.string.progress_text, 0)
//                }
//
//            }
//        }
    }

    private fun taskItemClicked(taskItem : TaskData) {
        Toast.makeText(this, "Clicked: ${taskItem.taskText}", Toast.LENGTH_LONG).show()

//        taskItem.taskStatus != taskItem.taskStatus
//        taskItem.getItemId()
//
//        binding.tasksRecycler.adapter?.getBindingAdapterPosition()
//        binding.tasksRecycler.adapter?.notifyItemChanged()

        // Launch second activity, pass part ID as string parameter
//        val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
//        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, taskItem.id.toString())
//        startActivity(showDetailActivityIntent)
    }

    private fun createTestData() : List<TaskData> {
        val taskList = ArrayList<TaskData>()
        taskList.add(TaskData("Take medications", false))
        taskList.add(TaskData("Water the flower", true))
        taskList.add(TaskData("Wash dishes", false))
        taskList.add(TaskData("Take medications Take medications Take medications Take medications Take medications Take medications", false))
        taskList.add(TaskData("Water the flower", true))
        taskList.add(TaskData("Wash dishes", false))
        taskList.add(TaskData("Take medications", false))
        taskList.add(TaskData("Water the flower", true))
        taskList.add(TaskData("Wash dishes", false))
        taskList.add(TaskData("Take medications", false))
        taskList.add(TaskData("Water the flower", true))
        taskList.add(TaskData("Wash dishes", false))
        taskList.add(TaskData("Take medications", false))
        taskList.add(TaskData("Water the flower", true))
        taskList.add(TaskData("Wash dishes", false))
        return taskList
    }
}