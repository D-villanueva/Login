package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.login.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


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
        binding.btnLogin.setOnClickListener {

            val user = binding.txtUser.text.toString()
            val pass = binding.txtPassword.text.toString()
            val activeUser = getData(user)
            val destination = LoginFragmentDirections.actionLoginFragmentToHomeFragment(activeUser)
            if (activeUser.password == pass) {
                view.findNavController().navigate(destination)
            }else Toast.makeText(activity, "verifique los datos", Toast.LENGTH_SHORT).show()
        }

        binding.btnSignIn.setOnClickListener {

            view.findNavController().navigate(R.id.signInFragment)
        }
    }

}