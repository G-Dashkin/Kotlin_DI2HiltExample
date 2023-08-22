package com.example.kotlin_di2hiltexample.Hilt2.step2.di


import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.repository.UserRepository
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.usecases.GetUserNameUseCase
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.usecases.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

// DomainModule который помечен компонентом, так как мы будем исопльзовать ЮзКейсы из ВьюМодели.
// Этот класс предоставляет нам два ЮзКейса – GetUserNameUseCase и SaveUserNameUseCase

// добавляем аннотацию @Module
@Module
@InstallIn(ViewModelComponent::class) // Так как мы используем все эти объекты из ВьюМодели, у нас все это будет лежаать в компоненте ViewModel
class DomainModule {

    // Здесь реализовываем два ЮзКейса. Напишем их через провайд-методы
    // Сделаем провайд-методы. Добавляем аннотацию @Provides

    // репозиторий положем в оба этих юзкейса. т.е. оба юзкейса будут иметь ссылку на один и тот же
    // репозиторий, так как он был помечен как синглТон

    // Сначала сделаем метод возвращающий GetUserNameUseCase
    @Provides
    fun provideGetUserNameUserCase(userRepository: UserRepository) : GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }

    // И сделаем метод сохраняющий имя пользователя SaveUserNameUseCase
    @Provides
    fun provideSaveUserNameUserCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }

    // Далее вьюМодель созданная через "by viewModels()" заберет по цепочке ЮзКейсы из этого DomainModule

}