package com.example.kotlin_di2hiltexample.Hilt2.step2.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.models.SaveUserNameParam
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.models.UserName
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.usecases.GetUserNameUseCase
import com.example.kotlin_di2hiltexample.Hilt2.step2.domain.usecases.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Во ВьюМоделе добавим аннотацию @HiltViewModel к классу. Это означает, что эту ВьюМодель нам придется создавать
// Если у нас есть какие то входные параметры, то помечаем ее аннотацией @Inject с конструктором.
// Если входных параметров нет, то в конструкторе будет пусто.
@HiltViewModel
class MainViewModel @Inject constructor( // Добавим аннотацию @Inject с консруктором, как в даггере.
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ): ViewModel() {

    private var liveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = liveData

    init {
        Log.d("MyLog", "ViewModel created")
    }

    override fun onCleared() {
        Log.d("MyLog", "ViewModel cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        liveData.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        liveData.value = "${userName.firstName} ${userName.lastName}"
    }

}