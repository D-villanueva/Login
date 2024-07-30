package com.example.login.Data

import com.example.login.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object UserDB {
    private val Users: MutableList<Users> = mutableListOf()

    suspend fun addUsers(
        user: Users
    ) {
        delay(2000)
        Users.add(user)
    }


    suspend fun getUserByIndex(inputIndex: Int): Users? {
        delay(2000)
        return Users.find { it.index == inputIndex }
    }

   suspend fun existentUser(username: String): Boolean {
        delay(2000)
        return Users.contains(Users.find { it.email==username })
    }

    suspend fun generateIndex(): Int {
        delay(2000)
        return Users.count() + 1
    }

    suspend fun findId(username: String): Int {
        delay(2000)
        return  Users.find { it.email == username }?.index ?: 0
    }

}
