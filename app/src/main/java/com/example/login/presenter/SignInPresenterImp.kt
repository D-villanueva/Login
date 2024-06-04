package com.example.login.presenter

import com.example.login.model.UserDB
import com.example.login.model.Users
import com.example.login.view.SignInFragment
import com.example.login.view.SignInView

class SignInPresenterImp(private val signInView: SignInView) : SignInPresenter {
    override fun addUser(
        name: String,
        lastName: String,
        age: Int,
        email: String,
        password: String,
        active: Boolean
    ) {
        if (name.isNotEmpty() && lastName.isNotEmpty() && age.toString()
                .isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && active.toString()
                .isNotEmpty()
        ) {
            val newUser = Users(name, lastName, age, email, password, active)
            if (UserDB.existentUser(email)) {
                signInView.existent("Usuario existente")
            } else {
                UserDB.addUsers(newUser)
                signInView.success("Usuario agregado con exito")
            }
        } else {
            signInView.error("Error en formulario")
        }
    }
}