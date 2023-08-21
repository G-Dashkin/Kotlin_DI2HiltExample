package com.example.kotlin_di2hiltexample.Hilt1.step1

import android.util.Log

// В данном случае класс WiFiManager зависит от класса WiFiSettings
// т.е. нам обязательно нужно передать класс WiFiSettings, чтобы можно было инициализировать
// WiFiManager, а для этого нужно сначала инициализировать WiFiSettings
class WiFiManager(private val settings: WiFiSettings) {
    fun connect() {
        settings.openConnection()
    }

    fun sendMessage() {
        settings.writeBytes()
    }

}

class WiFiSettings {
    fun openConnection(){
        println("Connected")
    }

    fun writeBytes(){
        println("Hello!")
    }
}