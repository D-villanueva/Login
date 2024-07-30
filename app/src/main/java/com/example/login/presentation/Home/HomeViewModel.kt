package com.example.login.presentation.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.Data.UserDB
import com.example.login.model.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class HomeViewModel : ViewModel() {

    private val _msg = MutableLiveData<String>()
    private val _user = MutableLiveData<Users>()
    val msg : LiveData<String> get () = _msg
    val user : LiveData<Users> get () = _user
   //fun getDataByIndex(inputIndex: Int): Users? {
   //    val coroutineScope = CoroutineScope(Dispatchers.IO)
   //    val user = coroutineScope.async { UserDB.getUserByIndex(inputIndex)}
   //    return user.await()
   //
   //}

fun getDataByIndex(inputIndex:Int) {
    viewModelScope.launch {
        _user.value =  UserDB.getUserByIndex(inputIndex)
    }



}


}

