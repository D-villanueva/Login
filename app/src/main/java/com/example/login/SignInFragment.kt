package com.example.login

import android.icu.number.IntegerWidth
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.login.databinding.FragmentHomeBinding
import com.example.login.databinding.FragmentSignInBinding
import com.example.login.Users


class SignInFragment : Fragment() {
    private var _binding : FragmentSignInBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIn.setOnClickListener(){
            getValues()
            view.findNavController().navigate(R.id.loginFragment)
        }
    }
private fun getValues(){
    val name = binding.txtName.text.toString()
    val lastName = binding.txtLastName.text.toString()
    val getAge = binding.txtAge.text.toString()
    val ageInt = Integer.parseInt(getAge)
    val email = binding.txtUser.text.toString()
    val password = binding.txtPassword.text.toString()
    val user:Users = Users(name,lastName, ageInt,email,password, true)
    addUsers(user)
}

}