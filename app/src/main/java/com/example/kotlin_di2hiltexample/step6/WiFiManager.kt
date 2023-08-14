package com.example.kotlin_di2hiltexample.step6

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

class WiFiManager(private val settings: WiFiSettings) {
    fun connect() {
        settings.openConnection()
    }

    fun sendMessage() {
        settings.writeBytes()
    }

}

class WiFiSettings @Inject constructor() {
    fun openConnection(){
        Log.d("MyLog", "Connected")
    }

    fun writeBytes(){
        Log.d("MyLog", "Hello!")
    }
}