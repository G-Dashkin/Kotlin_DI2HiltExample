package com.example.kotlin_di2hiltexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.databinding.ActivityMainBinding
import com.example.kotlin_di2hiltexample.step2.ActivityStep2
import com.example.kotlin_di2hiltexample.step3.ActivityStep3
import com.example.kotlin_di2hiltexample.step4.ActivityStep4
import com.example.kotlin_di2hiltexample.step5.ActivityStep5
import com.example.kotlin_di2hiltexample.step6.ActivityStep6

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            step2.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityStep2::class.java))
            }
            step3.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityStep3::class.java))
            }
            step4.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityStep4::class.java))
            }
            step5.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityStep5::class.java))
            }
            step6.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityStep6::class.java))
            }
        }

    }
}