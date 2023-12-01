package com.example.polytechandroidclasses

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeProgressButton = findViewById<Button>(R.id.buttonProgress)
        val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
        val progressText = findViewById<TextView>(R.id.textProgress)

        changeProgressButton.setOnClickListener {
            circularProgressBar.apply {
                if (progress < 100f) {
                    progressText.text = getString(
                        R.string.progress_text,
                        (progress + 20f).roundToInt()
                    )
                    setProgressWithAnimation(progress + 20f, 1000)
                } else {
                    setProgressWithAnimation(0f, 1000)
                    progressText.text = getString(R.string.progress_text, 0)
                }

            }
        }
    }
}