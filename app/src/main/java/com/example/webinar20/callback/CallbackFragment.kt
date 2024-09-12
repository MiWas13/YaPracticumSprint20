package com.example.webinar20.callback

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.webinar20.databinding.FragmentCallbackBinding
import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.launch

class CallbackFragment : Fragment() {

    private var _binding: FragmentCallbackBinding? = null
    private val binding get() = _binding!!
    private val viewModel = CallbackViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCallbackBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.launchRequest.setOnClickListener {
            lifecycleScope.launch {

                    val result =
                        viewModel.fetchDataWithRetrofit("b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0")

                if (result is Result.Ok) {
                    binding.result.text = result.response.name
                }


            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

sealed interface Result {
    class Ok(val response: ApiResponse) : Result

    sealed class Error : Result {

        class Backend(
            val url: String,
            val code: Int,
            val error: Throwable
        ) : Error()

        class Network(val url: String, val error: Throwable) : Error()
    }
}