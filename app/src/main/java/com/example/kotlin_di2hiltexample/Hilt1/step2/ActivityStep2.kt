package com.example.kotlin_di2hiltexample.Hilt1.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_di2hiltexample.R
import com.example.kotlin_di2hiltexample.databinding.ActivityStep2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Аннотация @AndroidEntryPoint нужно чтобы указать библиотеке Hilt как вживить в данный класс - MainActivityStep2,
// другие классы помеченные аннотацией @Inject
@AndroidEntryPoint
class ActivityStep2 : AppCompatActivity() {

    // Указывая аннотацию @Inject мы как бы говорим библиотеке Hilt дать нам инициалзированный WiFiManager
    // и библиотека Hilt начинает искать есть ли этот класс. В данном случае у нас есть классы и WiFiManager и
    // и WiFiSettings помеченные @Inject с конструктором
    @Inject
    lateinit var wiFiManager: WiFiManager
    private lateinit var binding: ActivityStep2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStep2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Теперь нам не нужно инициализировать класс WiFiManager, чтобы обращаться  к его методам
        // Однако в данном случае всегда будут создаваться новые инстанции класса wiFiManager
        wiFiManager.connect()
        wiFiManager.sendMessage()
        // Можно запустить приложение и проверить, что все работает.

    }
}