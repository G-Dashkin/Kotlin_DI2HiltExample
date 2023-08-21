package com.example.kotlin_di2hiltexample.Hilt1.step5

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Представим, что WiFiManager и WiFiSettings это не наши классы и уберем из них @Inject constructor
// в таком случае нам нужно создать модуль, чтобы Hilt мог инициализировать нам эти инстанции

// Помечаем данный класс аннотацией @Module, чтобы Hilt знал откуда нам брать все эти инстанции
// и где будет это установленно (а application, фрагмента или активити) при помощи аннотации @InstallIn()

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    // теперь нам нужно прописать как будет создана инстанция

    @Provides // при помощи аннотации @Provides мы говорим, чтобы нам предоставили инстанцию
    @Singleton // Также помечаем функцию которая будет создавать нам инстанию аннотацией @Singleton, чтобы у нас создвалась только одна инстанцию на все приложение.
    fun provideWiFiManager(settings: WiFiSettings): WiFiManager {
        // В данной функции мы указываем, что нам нужно вернуть инстанцию класса WiFiManager
        // просто указываем return и здесь описываем как создается WiFiManager. Но для этого нам нужно
        // передать sittings - его мы передаем в конструкторе функции
        return WiFiManager(settings)
    }

    // И чтобы Hilt знал откуда брать WiFiSettings, для него тоже нужно создать такую же функцию
    @Provides
    fun provideWiFiSettings(): WiFiSettings{
        return WiFiSettings()
    }

    // т.е. здесь происходит следующее - когда мы запросим инстанцию WiFiManager в функцие provideWiFiManager()
    // библиотека Hilt будет искать у себя в модуле (в данном классе) имеется ли такая инстанция - WiFiManager
    // Но при создании WiFiManager заметит, что нужен WiFiSettings и будет искать в этом же модуле - если ли
    // инструкции по созданию WiFiSettings и найдет и их при помощи функции provideWiFiSettings(), поэтому сможет
    // вставить инстанцию WiFiSettings в функцию provideWiFiManager()

}