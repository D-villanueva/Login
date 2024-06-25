package com.example.login.presentation.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.Data.UserDB
import com.example.login.model.LoginData
import com.example.login.model.Users

class LoginViewModel : ViewModel() {
    //private val data = MutableLiveData<LoginData>()
    //private val _loginData = MutableLiveData<LoginData>()
    //val loginData : LiveData<LoginData> get() = _loginData

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> get() = _errorMsg

    private val _loginSucces = MutableLiveData<Users>()
    val loginSuccess: LiveData<Users> get() = _loginSucces
    fun validarUsuario(email: String, pass: String) {

        if (email.isEmpty()) _errorMsg.value = "Email vacio"
        else if (pass.isEmpty()) _errorMsg.value = "Password vacio"
        else if (pass.isNotEmpty() && email.isNotEmpty()) {
            val currentUser = UserDB.getUser(email)
            currentUser?.let { _loginSucces.value = it}
        }


        //if (email.isEmpty() && pass.isEmpty()) {_loginData.value = LoginData.EmptyLogin}
        //else {
        //    val currentUser = UserDB.getUser(email)
        //    if (currentUser == null) {
        //        _loginData.value = LoginData.UserNotFound
        //    }
        //    else {
        //        when (email.isNotEmpty()) {
        //            (currentUser.password == pass) -> {
        //                _loginData.value = LoginData.LoginSuccess(currentUser)
        //            }
        //            (pass.isEmpty()) -> {
        //                _loginData.value = LoginData.EmptyPassword("Ingrese un password")
        //            }
//
        //            (currentUser.password != pass) -> {
        //                _loginData.value = LoginData.WrongPass
        //            }
//
        //            else -> {
        //                _loginData.value = LoginData.Default
        //            }
        //        }
        //    }
        //}


    }


}