package com.example.login.Data

import com.example.login.model.Users

object UserDB {
    private val Users: MutableList<Users> = mutableListOf()

    fun addUsers(
        user: Users
    ) {
        Users.add(user)
    }


    fun getUser(username: String): Users? {
        return Users.find { it.email == username }
    }

    fun existentUser(username: String): Boolean {
        return Users.contains(Users.find { it.email==username })
    }

}
