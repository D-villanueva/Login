package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtPassword: EditText
    private lateinit var txtUser: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtUser = findViewById(R.id.txtUser)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        login()
    }

    private fun login() {
        btnLogin.setOnClickListener() {
            val user = txtUser.text.toString()
            val pass = txtPassword.text.toString()

                val intent = Intent(this, AppActivity::class.java)
                intent.putExtra("user", user)
                this.startActivity(intent)


        }
    }
}
