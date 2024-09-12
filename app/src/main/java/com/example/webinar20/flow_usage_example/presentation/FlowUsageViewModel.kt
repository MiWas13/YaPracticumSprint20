package com.example.webinar20.flow_usage_example.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.webinar20.flow_usage_example.domain.FlowUsageUseCase
import kotlinx.coroutines.launch

class FlowUsageViewModel(val useCase: FlowUsageUseCase) : ViewModel() {
    fun makeRequest() {
        viewModelScope.launch {
            useCase.invoke().collect {
                Log.e("FLOOOOW", it)
            }
        }
    }
}