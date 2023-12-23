package com.example.polytechandroidclasses

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnotherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        val textView = findViewById<TextView>(R.id.text_view)
        val receivedText = intent.getStringExtra(EXTRA_DATA)

        textView.text = receivedText
    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"

        fun createIntent(context: Context, data: String): Intent {
            return Intent(context, AnotherActivity::class.java)
                .putExtra(EXTRA_DATA, data)
        }
    }
}