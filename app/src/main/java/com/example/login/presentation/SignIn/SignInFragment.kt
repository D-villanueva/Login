package com.example.login.presentation.SignIn

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
import com.example.login.databinding.FragmentSignInBinding
import com.example.login.model.RequestUsers
import com.example.login.model.Users
import com.example.login.view.SignInView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignInViewModel by viewModels()
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
        initializeObserver()
    }

    private fun initializeListeners() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.txtUser.text.toString()
            val password = binding.txtPassword.text.toString()
            val newUser = RequestUsers(binding.txtUser.text.toString(),
                binding.txtLastName.text.toString(),
                binding.txtAge.text.toString().toInt(),
                email,
                password,
                true)
            viewModel.addUser(email,password, newUser)

        }

    }

    private fun initializeObserver(){
        viewModel.errorMsg.observe(viewLifecycleOwner) { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }

    }



}


