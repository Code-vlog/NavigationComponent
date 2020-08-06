package com.goodwilldev.navigationcomponent.home_

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.goodwilldev.navigationcomponent.R
import com.goodwilldev.navigationcomponent.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        binding.button.setOnClickListener {
            val text = binding.nameEt.editText?.text.toString()
            if (text.isEmpty()) {
                binding.nameEt.isErrorEnabled = true
                binding.nameEt.error = "Invalid input"
            } else {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToSecondFragment(text)
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

}