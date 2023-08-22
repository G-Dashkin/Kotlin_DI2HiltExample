package com.example.kotlin_di2hiltexample.Hilt3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.Hilt3.step1.ActivityHilt3Step1
import com.example.kotlin_di2hiltexample.Hilt3.step2.ActivityHilt3Step2
import com.example.kotlin_di2hiltexample.Hilt3.step3.ActivityHilt3Step3
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt3Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            step1.setOnClickListener {
                startActivity(Intent(this@HiltActivity3, ActivityHilt3Step1::class.java))
            }

            step2.setOnClickListener {
                startActivity(Intent(this@HiltActivity3, ActivityHilt3Step2::class.java))
            }

            step3.setOnClickListener {
                startActivity(Intent(this@HiltActivity3, ActivityHilt3Step3::class.java))
            }

        }

    }
}