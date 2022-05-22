package com.example.inspectionbugpoc.android

import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.inspectionbugpoc.Greeting

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO this method is not found by inspection, but build passes
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            mapOf<String, Boolean>()
        }

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
