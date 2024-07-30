package com.example.login.view

import android.os.Message
import com.example.login.model.Users

interface LoginView{
    fun success(Index:Int)
    fun error(message: String)
    
}