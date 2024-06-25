package com.example.login.presentation.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.login.Data.UserDB
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.model.LoginData
import com.example.login.model.Users
import com.example.login.view.LoginView


class LoginFragment : Fragment() {
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
            initializeObserver()
        }

        binding.btnSignIn.setOnClickListener {

            view?.findNavController()?.navigate(R.id.signInFragment)
        }
    }

    //private fun observer() {
    //   viewModel.loginData.observe(viewLifecycleOwner){loginData -> when (loginData){
    //       LoginData.Default -> Toast.makeText(context, "Error no identificado", Toast.LENGTH_LONG).show()
    //       LoginData.EmptyLogin -> Toast.makeText(context, "Ingrese datos en el formulario", Toast.LENGTH_LONG).show()

    //       LoginData.EmptyUser -> Toast.makeText(context, "Ingrese un usuario valido", Toast.LENGTH_LONG).show()
    //       LoginData.UserNotFound -> Toast.makeText(context, "El usuario no existe", Toast.LENGTH_LONG).show()
    //       LoginData.WrongPass -> Toast.makeText(context, "Password incorrecto", Toast.LENGTH_LONG).show()
    //       is LoginData.LoginSuccess -> {
    //           val destination =
    //               LoginFragmentDirections.actionLoginFragmentToHomeFragment(loginData.users)
    //           view?.findNavController()?.navigate(destination)
    //       }

    //       is LoginData.EmptyPassword -> Toast.makeText(context, loginData.error, Toast.LENGTH_LONG).show()
    //   } }
    //}

    private fun initializeObserver() {
        viewModel.errorMsg.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }
        viewModel.loginSuccess.observe(viewLifecycleOwner) { user ->
            val destination =
                LoginFragmentDirections.actionLoginFragmentToHomeFragment(user)
            view?.findNavController()?.navigate(destination)
        }
    }

}