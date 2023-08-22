package com.example.kotlin_di2hiltexample.Hilt3.step3

import android.util.Log

class NetworkAdapter private constructor(builder: Builder){

    private val protocol: String?
    private val host: String?

    init {
        this.protocol = builder.protocol
        this.host = builder.host
    }

    fun log() {
        Log.d("MyLog", "NetworkAdapter: $this, protocol: $protocol, host: $host")
    }

    class Builder {
        var protocol: String? = null
            private set
        var host: String? = null
            private set

        fun protocol(protocol: String) = apply { this.protocol = protocol }
        fun host(host: String) = apply { this.host = host }
        fun build() = NetworkAdapter(this)
    }
}