package com.example.webinar20.coroutines_usage_example.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webinar20.databinding.FragmentSomeFragmentBinding
import com.example.webinar20.coroutines_usage_example.data.SomeRepositoryImpl
import com.example.webinar20.coroutines_usage_example.domain.SomeUseCase

class SomeFragment : Fragment() {
    private var _binding: FragmentSomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel = SomeViewModel(SomeUseCase(SomeRepositoryImpl()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doRequestFromViewModel()
    }
}