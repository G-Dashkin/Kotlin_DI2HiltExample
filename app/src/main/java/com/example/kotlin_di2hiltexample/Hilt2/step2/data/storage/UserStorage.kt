package com.example.kotlin_di2hiltexample.Hilt2.step2.data.storage

import com.example.kotlin_di2hiltexample.Hilt2.step2.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}