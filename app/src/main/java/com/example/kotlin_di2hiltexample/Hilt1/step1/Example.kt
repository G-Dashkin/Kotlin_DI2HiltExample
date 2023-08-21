package com.example.kotlin_di2hiltexample.Hilt1.step1

fun main() {

    val settings = WiFiSettings()
    val wiFiManager = WiFiManager(settings)

    wiFiManager.connect()
    wiFiManager.sendMessage()
}