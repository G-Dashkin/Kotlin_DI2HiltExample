package com.example.kotlin_di2hiltexample.step5

import javax.inject.Inject

// Теперь разберем модули. Они нужны, чтобы внедрять зависимости, если классы не наши.
// если классы наши, то мы можем сделать Inject в конструктор, а если это другая библиотека, то у нас нет
// доступа к классу и прописать конструктор мы там не сможем

// Представим, что WiFiManager и WiFiSettings это не наши классы и уберем из них @Inject constructor
// в таком случае нам нужно создать модуль, чтобы Hilt мог инициализировать нам эти инстанции

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
        println("Connected")
    }

    fun writeBytes(){
        println("Hello!")
    }
}