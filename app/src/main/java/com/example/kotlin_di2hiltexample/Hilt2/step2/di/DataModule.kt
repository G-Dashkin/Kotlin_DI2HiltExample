package com.example.kotlin_di2hiltexample.Hilt2.step2.di

import android.content.Context
import com.example.kotlin_di2hiltexample.Hilt2.step2.data.repository.UserRepositoryImpl
import com.example.kotlin_di2hiltexample.Hilt2.step2.data.storage.UserStorage
import com.example.kotlin_di2hiltexample.Hilt2.step2.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Мы создаем модули, которые будут предоставлять наши зависимости.
// DataModule предоставляем UserStorage и UserRepository. Все это является СинглТоном

// добавляем аннотацию @Module
@Module
@InstallIn(SingletonComponent::class) // Добавляем аннотацию @InstallIn – для СинглТона.
class DataModule {

    // Делаем провайдер для стораджа, он возвращает sharedPreferences и здесь нам нужен контекст.
    @Provides // добавляем аннотацию @Provides из даггера
    @Singleton // И добавляем сюда аннотацию @Singleton, чтобы скомпилировать код
    fun provideUserStorage(@ApplicationContext context: Context) : UserStorage { // И чтобы передавать контекст нужно добавить аннотацию @ApplicationContext
        return SharedPrefUserStorage(context = context)
    }

    // Создаем провайд метод репозитория. Он принимает UserStorage и возвращает реализацию репозиторию.
    @Provides // добавляем аннотацию @Provides из даггера
    @Singleton
    fun provideUserRepository(userStorage: UserStorage) : UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}

// DataModule готов
// Далее к ЮзКейсам подключится репозиторий из стораджа.