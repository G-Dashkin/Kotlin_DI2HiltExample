package com.example.kotlin_di2hiltexample.step1

fun main() {

    val settings = WiFiSettings()
    val wiFiManager = WiFiManager(settings)

    wiFiManager.connect()
    wiFiManager.sendMessage()
}