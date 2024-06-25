package com.example.login.model

sealed class LoginData {
    data object Default : LoginData()
    data class LoginSuccess (val users: Users): LoginData()
    data object EmptyLogin:LoginData()
    data object EmptyUser:LoginData()
    data class EmptyPassword(val error:String):LoginData()
    data object UserNotFound:LoginData()
    data object WrongPass:LoginData()

}