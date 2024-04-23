package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var container: FragmentContainerView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //container = findViewById(R.id.LoginContainer)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.LoginContainer ,LoginFragment())
            .commit()
    }



}
