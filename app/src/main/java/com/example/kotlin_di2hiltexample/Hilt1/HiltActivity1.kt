package com.example.kotlin_di2hiltexample.Hilt1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.Hilt1.step2.ActivityStep2
import com.example.kotlin_di2hiltexample.Hilt1.step3.ActivityStep3
import com.example.kotlin_di2hiltexample.Hilt1.step4.ActivityStep4
import com.example.kotlin_di2hiltexample.Hilt1.step5.ActivityStep5
import com.example.kotlin_di2hiltexample.Hilt1.step6.ActivityStep6
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt1Binding

class HiltActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            step2.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, ActivityStep2::class.java))
            }
            step3.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, ActivityStep3::class.java))
            }
            step4.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, ActivityStep4::class.java))
            }
            step5.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, ActivityStep5::class.java))
            }
            step6.setOnClickListener {
                startActivity(Intent(this@HiltActivity1, ActivityStep6::class.java))
            }
        }
    }
}