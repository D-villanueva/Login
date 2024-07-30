package com.example.login.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Users(
    var name: String,
    val lastName: String,
    val age: Int,
    val email: String,
    var password: String,
    val active: Boolean,
    val index: Int
):Parcelable

@Parcelize
data class RequestUsers(
    var name: String,
    val lastName: String,
    val age: Int,
    val email: String,
    var password: String,
    val active: Boolean,
):Parcelable

