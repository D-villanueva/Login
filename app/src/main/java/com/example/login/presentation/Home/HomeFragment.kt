package com.example.login.presentation.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.login.databinding.FragmentHomeBinding
import com.example.login.presentation.Login.LoginFragmentArgs

class HomeFragment : Fragment() {
   private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    val args:LoginFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtGetUsuario.text = args.Users.name
        binding.txtGetEmail.text = args.Users.email
        binding.txtGetActive.text = args.Users.active.toString()
    }

}