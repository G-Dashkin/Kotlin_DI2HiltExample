package com.example.kotlin_di2hiltexample.Hilt3.step1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt3Step1Binding

class ActivityHilt3Step1 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt3Step1Binding
    lateinit var service: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt3Step1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        service = NetworkService()
        service.log()

    }
}