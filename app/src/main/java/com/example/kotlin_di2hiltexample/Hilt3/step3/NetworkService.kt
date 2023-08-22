package com.example.kotlin_di2hiltexample.Hilt3.step3

import android.util.Log
import javax.inject.Inject

class NetworkService @Inject constructor() {
    fun log () {
        Log.d("MyLog", "NetworkService: $this")
    }
}