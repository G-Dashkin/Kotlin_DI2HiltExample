package com.example.kotlin_di2hiltexample.Hilt1.step5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_di2hiltexample.databinding.ActivityStep5Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Здесь все работает теперь точно так же можно запустить приложение и проверить, что у нас все работает
@AndroidEntryPoint
class ActivityStep5 : AppCompatActivity() {

    @Inject
    lateinit var wiFiManager: WiFiManager
    private lateinit var binding: ActivityStep5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStep5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Выведем в лог id инстанции wiFiManager, чтобы увидеть, что у на cоздается один и
        // тот же объект при помощи аннотаций @InstallIn(SingletonComponent::class) и @Singleton
        // Чтобы проверить можно просто несолько раз закрыть и открыть один и тот же экран
        Log.d("MyLog", "ActivityStep5 instance id: $wiFiManager")

        wiFiManager.connect()
        wiFiManager.sendMessage()
    }
}