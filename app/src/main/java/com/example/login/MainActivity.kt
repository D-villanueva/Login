package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        login()
    }

    private fun login() {
        binding.btnLogin.setOnClickListener() {
            val user = binding.txtUser.text.toString()
            val pass = binding.txtPassword.text.toString()

                val intent = Intent(this, AppActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)


        }
    }
}
