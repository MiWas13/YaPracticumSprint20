package com.example.webinar20.flow_usage_example.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webinar20.databinding.FragmentFlowUsageBinding
import com.example.webinar20.flow_usage_example.data.FlowUsageRepositoryImpl
import com.example.webinar20.flow_usage_example.domain.FlowUsageUseCase

class FlowUsageFragment : Fragment() {

    private var _binding: FragmentFlowUsageBinding? = null
    private val binding get() = _binding!!

    private val viewModel = FlowUsageViewModel(FlowUsageUseCase(FlowUsageRepositoryImpl()))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFlowUsageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.makeRequest()
    }
}