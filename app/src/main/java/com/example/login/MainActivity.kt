package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var container: FragmentContainerView
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeNavigation()
    }

private fun initializeNavigation(){
    val navHostFragment =
       supportFragmentManager.findFragmentById(R.id.nav_fragmentHost) as NavHostFragment

    navController = navHostFragment.navController
}

}
