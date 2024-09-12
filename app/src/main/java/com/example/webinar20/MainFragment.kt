package com.example.webinar20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.webinar20.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.buttonSharedState.setOnClickListener {
            findNavController().navigate(R.id.SharedStateFragment)
        }
        binding.buttonStateFlow.setOnClickListener {
            findNavController().navigate(R.id.StateFlowFragment)
        }
        binding.buttonCallback.setOnClickListener {
            findNavController().navigate(R.id.CallbackFragment)
        }
        binding.buttonSomeFragment.setOnClickListener {
            findNavController().navigate(R.id.SomeFragment)
        }
        binding.buttonUsageFragment.setOnClickListener {
            findNavController().navigate(R.id.FlowUsageFragment)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}