package com.example.login.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Users(
    var name: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val password: String,
    val active: Boolean
):Parcelable

