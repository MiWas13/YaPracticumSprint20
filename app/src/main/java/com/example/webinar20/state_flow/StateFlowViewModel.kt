package com.example.webinar20.state_flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StateFlowViewModel : ViewModel() {

    private val _screenStateFlow = MutableStateFlow(ScreenState(0, "Пока ничего"))
    val screenStateFlow = _screenStateFlow.asStateFlow()

    init {
        requestServer()
    }

    fun increment() {
        _screenStateFlow.update {
            it.copy(
                counterValue = it.counterValue + 1,
                message = "плюс"
            )
        }
    }

    fun decrement() {
        _screenStateFlow.update {
            it.copy(
                counterValue = it.counterValue - 1,
                message = "минус"
            )
        }
    }

    private fun requestServer() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(10000L)
            _screenStateFlow.update {
                it.copy(
                    counterValue = it.counterValue + 5,
                    message = "cервер ответил плюс 5",
                    messageFromServer = true
                )
            }
        }
    }

}

data class ScreenState(
    val counterValue: Int,
    val message: String?,
    val messageFromServer: Boolean = false
)
