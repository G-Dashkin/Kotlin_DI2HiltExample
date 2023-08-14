package com.example.kotlin_di2hiltexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Нам нужен класс, который наследуется от Application() с аннотацией @HiltAndroidApp
// чтобы класс App запустился, кго нужно указать в манифесте
@HiltAndroidApp
class App: Application() {

}