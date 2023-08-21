package com.example.kotlin_di2hiltexample.Hilt1.step2

import javax.inject.Inject

// Для использования библиотеки Hilt, нужно отличать наши клиссы (созданные нами), от классов сторонних
// библиотек. Для наших классов используется аннотация @Inject с конструктором
// Аннотация @Inject указывет, что Hilt может создать эти классы

class WiFiManager @Inject constructor(private val settings: WiFiSettings) {
    fun connect() {
        settings.openConnection()
    }

    fun sendMessage() {
        settings.writeBytes()
    }

}

class WiFiSettings @Inject constructor() {
    fun openConnection(){
        println("Connected")
    }

    fun writeBytes(){
        println("Hello!")
    }
}