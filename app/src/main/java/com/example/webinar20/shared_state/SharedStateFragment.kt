package com.example.webinar20.shared_state

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.webinar20.databinding.FragmentSharedStateBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SharedStateFragment : Fragment() {

    private var _binding: FragmentSharedStateBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSharedStateBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStartCount.setOnClickListener {
            lifecycleScope.launch {
                val mutableInteger = MutableInteger()

                val job1 = lifecycleScope.launch(Dispatchers.IO) {
                    repeat(10_000_000) {
                        mutableInteger.increment()
                    }
                }

                val job2 = lifecycleScope.launch(Dispatchers.IO) {
                    repeat(10_000_000) {
                        mutableInteger.increment()
                    }
                }
                job1.join()
                job2.join()
                binding.textviewResult.text = mutableInteger.getValue().toString()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class MutableInteger {
    private var value = 0
    private val mutex = Mutex()

    suspend fun increment() {
        mutex.withLock {
            value++
        }
    }

    fun getValue(): Int {
        return value
    }
}
