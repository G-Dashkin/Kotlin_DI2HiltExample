package com.example.kotlin_di2hiltexample.Hilt2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.Hilt2.step1.presentation.ActivityHilt2Step1
import com.example.kotlin_di2hiltexample.Hilt2.step2.presentation.ActivityHilt2Step2
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt2Binding

class HiltActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityHilt2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            step1.setOnClickListener {
                startActivity(Intent(this@HiltActivity2, ActivityHilt2Step1::class.java))
            }

            step2.setOnClickListener {
                startActivity(Intent(this@HiltActivity2, ActivityHilt2Step2::class.java))
            }

        }

    }
}