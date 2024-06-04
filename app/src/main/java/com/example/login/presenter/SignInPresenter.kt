package com.example.login.presenter

import com.example.login.model.UserDB
import com.example.login.model.Users

interface SignInPresenter {
    fun addUser(name: String,
                lastName: String,
                age: Int,
                email: String,
                password: String,
                active: Boolean)

}