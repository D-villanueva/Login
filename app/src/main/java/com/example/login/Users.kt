package com.example.login
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

var Data: MutableList<Users> = mutableListOf()
@Parcelize
data class Users(
    var name: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val password: String,
    val active: Boolean
):Parcelable

public
fun addUsers(user:Users
) {

    Data.add(user)

}

//fun findIndex(email: String) : Int{
//    var index : Int = -1
//
//    for (i in 0..Data.size){
//        if (Data[i].email == email)
//            index = i
//    }
//
//    return index
//
//}

fun getData(email: String):Users {
    var index: Int = -2

    for (i in 0..<Data.size) {
        if (Data[i].email == email) {
            index = i
        }
    }
    return Data[index]


}

fun size(): Int {
    val getSize = Data.size
    return getSize
}
