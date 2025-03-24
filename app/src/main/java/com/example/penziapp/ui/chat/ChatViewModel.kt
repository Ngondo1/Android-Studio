package com.example.penziapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.penziapp.data.model.*
import com.example.penziapp.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: ChatRepository) : ViewModel() {

    private val _responseState = MutableStateFlow<ResponseState>(ResponseState.Idle)
    val responseState: StateFlow<ResponseState> = _responseState

    fun submitPhoneNumber(phoneData: Map<String, String>) {
        viewModelScope.launch {
            _responseState.value = ResponseState.Loading
            try {
                val response = repository.submitPhoneNumber(phoneData)
                if (response.isSuccessful) {
                    _responseState.value = ResponseState.Success("Phone number submitted successfully.")
                } else {
                    _responseState.value = ResponseState.Error("Failed to submit phone number.")
                }
            } catch (e: Exception) {
                _responseState.value = ResponseState.Error(e.localizedMessage ?: "An error occurred")
            }
        }
    }
}

// State Management for UI
sealed class ResponseState {
    object Idle : ResponseState()
    object Loading : ResponseState()
    data class Success(val message: String) : ResponseState()
    data class Error(val error: String) : ResponseState()
}
