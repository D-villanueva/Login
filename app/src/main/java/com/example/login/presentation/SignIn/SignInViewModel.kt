package com.example.login.presentation.SignIn

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.Data.UserDB
import com.example.login.model.LoginData
import com.example.login.model.RequestUsers
import com.example.login.model.Users
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.*

class SignInViewModel : ViewModel() {

    private val _errorMsg = MutableLiveData<String>()


    val errorMsg: LiveData<String> get() = _errorMsg
    fun addUser(email: String, password: String, newUser: RequestUsers) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            viewModelScope.launch {
                val index = UserDB.generateIndex()
                val user = Users(newUser.name,
                    newUser.lastName,
                    newUser.age,newUser.email,
                    newUser.password,
                    newUser.active,index)
                UserDB.addUsers(user)
                _errorMsg.value = "Usuario Agregado"
            }
        }
    }


}