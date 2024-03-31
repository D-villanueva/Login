package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AppActivity : AppCompatActivity() {
    private lateinit var txtGetUsuario: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        txtGetUsuario = findViewById(R.id.txtGetUsuario)

        txtGetUsuario.text= intent?.extras?.getString("user")
    }
}