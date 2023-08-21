package com.example.kotlin_di2hiltexample.Hilt1.step6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.kotlin_di2hiltexample.R
import com.example.kotlin_di2hiltexample.databinding.ActivityStep5Binding
import com.example.kotlin_di2hiltexample.databinding.ActivityStep6Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityStep6 : AppCompatActivity() {

    @Inject
    lateinit var wiFiManager: WiFiManager
    val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityStep6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStep6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "ActivityStep6 instance id: $wiFiManager")
        mainViewModel.connect()
    }
}