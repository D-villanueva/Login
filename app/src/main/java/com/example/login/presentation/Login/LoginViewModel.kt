package com.example.login.presentation.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.Data.UserDB
import com.example.login.model.LoginData
import com.example.login.model.Users
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    //private val data = MutableLiveData<LoginData>()
    //private val _loginData = MutableLiveData<LoginData>()
    //val loginData : LiveData<LoginData> get() = _loginData

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> get() = _errorMsg
    var job: Job? = null
    private val _loginSucces = MutableLiveData<Int>()
    val loginSuccess: LiveData<Int> get() = _loginSucces
    fun validarUsuario(email: String, pass: String) {


        if (email.isEmpty() && pass.isEmpty()) _errorMsg.value = "Ingrese datos al formulario"
        else if (pass.isEmpty()) _errorMsg.value = "Password vacio"
        else if (pass.isNotEmpty() && email.isNotEmpty()) {
            viewModelScope.launch {
                val currentUser = UserDB.findId(email)
                if (currentUser != 0)
                { _loginSucces.value = currentUser}
                else{_errorMsg.value = "El usuario no existe"}
            }

        }

        fun cancelCoroutine(){
            job?.cancel()
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