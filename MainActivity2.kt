package com.example.application1mp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculators.R

class activity_main2: AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val tv_hello_name:TextView = findViewById(R.id.tv_hello_name)
        val greeting_name = intent.getStringExtra("firstName").toString()

        tv_hello_name.text = "Hello, $greeting_name"




    }
}