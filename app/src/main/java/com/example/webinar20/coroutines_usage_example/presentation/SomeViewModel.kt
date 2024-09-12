package com.example.webinar20.coroutines_usage_example.presentation

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.webinar20.coroutines_usage_example.domain.SomeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SomeViewModel(private val someUseCase: SomeUseCase) : ViewModel() {
    fun doRequestFromViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            someUseCase.invoke()
        }
    }
}