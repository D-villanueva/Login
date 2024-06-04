package com.example.login.view

import com.example.login.model.Users

interface SignInView {

    fun success(message: String)
    fun existent(message: String)
    fun error(message: String)
}