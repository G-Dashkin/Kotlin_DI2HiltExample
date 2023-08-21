package com.example.kotlin_di2hiltexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.Hilt1.HiltActivity1
import com.example.kotlin_di2hiltexample.Hilt2.HiltActivity2
import com.example.kotlin_di2hiltexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            exampleHilt1.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity1::class.java))
            }
            exampleHilt2.setOnClickListener {
                startActivity(Intent(this@MainActivity, HiltActivity2::class.java))
            }

        }

    }
}