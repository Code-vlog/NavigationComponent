package com.goodwilldev.navigationcomponent.second_

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.goodwilldev.navigationcomponent.R
import com.goodwilldev.navigationcomponent.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: SecondFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        val name = SecondFragmentArgs.fromBundle(requireArguments()).name
        name?.let {
            viewModel.setName(it)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.second_fragment, container, false)

        viewModel.getName().observe(viewLifecycleOwner, Observer {
            binding.nameTv.text = it
        })
        return binding.root
    }


}