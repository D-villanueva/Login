package com.example.login.presentation.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.model.Users
import com.example.login.presenter.LoginPresenter
import com.example.login.presenter.LoginPresenterImp
import com.example.login.view.LoginView


class LoginFragment : LoginView, Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()
    }

    private fun initializeListeners() {
        binding.btnLogin.setOnClickListener {
            val username = binding.txtUser.text.toString()
            val password = binding.txtPassword.text.toString()
            viewModel.validarUsuario(username, password)
        }

        binding.btnSignIn.setOnClickListener {

            view?.findNavController()?.navigate(R.id.signInFragment)
        }
    }

    private fun observer() {
        viewModel.
    }

}