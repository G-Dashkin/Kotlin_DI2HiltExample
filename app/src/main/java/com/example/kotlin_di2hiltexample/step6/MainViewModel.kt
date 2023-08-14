package com.example.kotlin_di2hiltexample.step6

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Для того, чтобы использовать inject во ViewModel используем аннотацию @HiltViewModel
// Чтобы вставить то что нам нужно используем @Inject constructor()
// также преимущество библиотеки Hilt при работе с ViewModel в том, что нам не нужно создавать фабрику вьюМодели
// если мы хотим что то передать во вьюМодель все это делает библиотека Hilt. Просто указываем, то что мы хотим
// передать в конструктор @Inject. Например, мы хотим передать WiFiManager, просто указываем это
@HiltViewModel
class MainViewModel @Inject constructor(
    val wiFiManager: WiFiManager
): ViewModel() {
    // и далее создает функции которые мы используем.

    // при создании ViewModel можно помоитреть на его инстанцию в функции init{}. Выыедем в лог
    init {
        Log.d("MyLog", "MainViewModel instance id: $wiFiManager")
    }

    fun connect() {
        wiFiManager.connect()
    }
}