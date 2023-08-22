package com.example.kotlin_di2hiltexample.Hilt3.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt2Step2Binding
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt3Step2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityHilt3Step2 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt3Step2Binding

    @Inject
    lateinit var service: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt3Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        service.log()

    }
}