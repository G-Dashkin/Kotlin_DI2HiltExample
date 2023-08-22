package com.example.kotlin_di2hiltexample.Hilt3.step3

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    fun provideNetworkAdapter(): NetworkAdapter {
        return NetworkAdapter.Builder()
            .protocol("HTTPS")
            .host("google.com")
            .build()
    }
}