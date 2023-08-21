package com.example.kotlin_di2hiltexample.Hilt2.step2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_di2hiltexample.Hilt2.step1.domain.presentation.MainViewModel
import com.example.kotlin_di2hiltexample.Hilt2.step1.domain.presentation.MainViewModelFactory
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt2Step2Binding

class ActivityHilt2Step2 : AppCompatActivity() {

    private lateinit var binding: ActivityHilt2Step2Binding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        viewModel.resultLiveData.observe(this, { text ->
            binding.dataTextView.text = text
        })


        binding.apply {

            sendButton.setOnClickListener {
                viewModel.save(dataEditText.text.toString())
            }

            receiveButton.setOnClickListener {
                viewModel.load()
            }

        }
    }
}