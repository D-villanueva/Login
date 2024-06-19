package com.example.login.presentation.Home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.model.UserDB
import com.example.login.model.Users

class HomeViewModel : ViewModel() {

    val data = MutableLiveData<UserDB>()

    fun getUser(email:String){
    data.postValue(email)
    }
}

