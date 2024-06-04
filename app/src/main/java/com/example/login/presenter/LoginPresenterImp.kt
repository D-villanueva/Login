package com.example.login.presenter

import com.example.login.model.UserDB
import com.example.login.view.LoginFragment

class LoginPresenterImp(private val loginView: LoginFragment):LoginPresenter{
    private val usersDB = UserDB
    override fun login(user: String, password: String) {
        val currentUser = usersDB.getUser(user)
        if (currentUser == null) loginView.error("Usuario no existe")
        currentUser?.let {
            if (it.password == password){
                loginView.success(currentUser)
            } else {
                loginView.error("Contraseña no valida")
            }
        }
    }


}