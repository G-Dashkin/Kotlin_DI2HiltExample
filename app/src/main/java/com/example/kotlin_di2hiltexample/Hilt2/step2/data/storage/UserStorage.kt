package com.example.kotlin_di2hiltexample.Hilt2.step1.data.storage

import com.example.kotlin_di2hiltexample.Hilt2.step1.data.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}