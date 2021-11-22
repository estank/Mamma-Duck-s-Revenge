package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When you click on the button it takes you to the next page
        val secondActButton = findViewById<Button>(R.id.button)
        secondActButton.setOnClickListener{
            val Intent = Intent(this,Activity2::class.java)
            startActivity(Intent)
        }

    }
    //anagha commit 10
    //evan commit
    //Mary commit
}