package com.example.login.presentation.Login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.model.UserDB
import com.example.login.model.Users

class LoginViewModel : ViewModel() {
    private val data = MutableLiveData<Users>()

    fun getUser(email:String){
        data.postValue(UserDB.getUser(email))
        validarUsuario(data?.value?.email, data?.value?.password)
    }

    fun validarUsuario(email: String, pass:String):Boolean{
        var status: Boolean= false
        val currentUser : Users? = data.value
        if (currentUser == null || !currentUser.equals(email) ) {status = false}
        if (currentUser?.password == pass) {
            status = true}
            return status
        }




}