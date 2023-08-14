package com.example.kotlin_di2hiltexample.step4

import javax.inject.Inject
import javax.inject.Singleton

// Аннотация @Singleton позволит нам создать один экземпляр данного класса на все приложение
@Singleton
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