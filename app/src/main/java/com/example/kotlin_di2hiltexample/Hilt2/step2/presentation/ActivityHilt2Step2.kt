package com.example.kotlin_di2hiltexample.Hilt2.step2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_di2hiltexample.databinding.ActivityHilt2Step2Binding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

// Добавим аннотацию @AndroidEntryPoint к классу MainActivity. MainActivity – это по сути точка входа и эта
// аннотация сделает все переменные, которые помечены как @Inject “заинжектенными”

// @AndroidEntryPoint – означет, что здесь у нас будут какие то инжекты.
@AndroidEntryPoint
class ActivityHilt2Step2 : AppCompatActivity() {

    // удаляем все лишнее.
    private lateinit var binding: ActivityHilt2Step2Binding

    // Создаем ВьюМодель через by viewModels()
    // “by viewModels()” возьмет вьюМодель, создаст ее, положет туда нужные зависимости и так
    // получится наша вьюМодель.
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHilt2Step2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("MyLog", "Activity created")

        // Использовать ViewModelProvider уже не нужно
        // viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

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