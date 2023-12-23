package com.example.polytechandroidclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    private var textValue = ""
    private lateinit var textEdit: AppCompatEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textEdit = findViewById(R.id.edittext_text)
        textValue = textEdit.text.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        textValue = textEdit.text.toString()
        outState.putString(SAVED_STRING_KEY, textValue)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val savedString = savedInstanceState.getString(SAVED_STRING_KEY)
        textValue = savedString.toString()
        textEdit.setText(textValue)
    }

    companion object {
        const val SAVED_STRING_KEY = "SAVED_TEXT_KEY"
//        const val EXTRA_DATA = "EXTRA_DATA"
//
//        fun createIntent(context: Context, data: String): Intent {
//            return Intent(context, SecondActivity::class.java)
//                .putExtra(EXTRA_DATA, data)
//        }
    }

}