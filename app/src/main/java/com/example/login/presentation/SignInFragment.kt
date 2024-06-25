package com.example.login.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.login.Data.UserDB
import com.example.login.R
import com.example.login.databinding.FragmentSignInBinding
import com.example.login.model.Users

import com.example.login.view.SignInView


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    private fun initializeListeners() {
        binding.btnSignIn.setOnClickListener {
            val name = binding.txtName.text.toString()
            val lastName = binding.txtLastName.text.toString()
            val getAge = binding.txtAge.text.toString()
            val ageInt = Integer.parseInt(getAge)
            val email = binding.txtUser.text.toString()
            val password = binding.txtPassword.text.toString()
            val newUser = Users(name, lastName, ageInt, email, password, true)
            UserDB.addUsers(newUser)
        }

    }


}


