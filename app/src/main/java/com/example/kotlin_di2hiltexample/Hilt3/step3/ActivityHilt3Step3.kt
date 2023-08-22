package com.example.kotlin_di2hiltexample.Hilt3.step3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt3Step3Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityHilt3Step3 : AppCompatActivity() {
    private lateinit var binding: ActivityHilt3Step3Binding

    @Inject
    lateinit var service: NetworkService

    @Inject
    lateinit var adapter: NetworkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt3Step3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        service.log()
        adapter.log()

    }
}