package com.example.login.presentation.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.login.databinding.FragmentHomeBinding
import com.example.login.presentation.Login.LoginFragmentArgs
import com.example.login.presentation.SignIn.SignInViewModel

class HomeFragment : Fragment() {
   private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val args:LoginFragmentArgs by navArgs()
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
        viewModel.getDataByIndex(args.Users)
        initializeObserver()
    }

    private fun initializeObserver(){
        viewModel.user.observe(viewLifecycleOwner) {
            binding.txtGetUsuario.text = it.name
            binding.txtGetEmail.text = it.email
            binding.txtGetActive.text = it.active.toString()
        }

    }

}