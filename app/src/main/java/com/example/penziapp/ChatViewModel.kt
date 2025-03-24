/* ChatViewModel.kt */

package com.example.penziapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatUiState(val messages: List<String> = emptyList())

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState

    fun sendMessage(message: String) {
        val newMessages = _uiState.value.messages + "You: $message"
        _uiState.value = _uiState.value.copy(messages = newMessages)

        // Simulate a response from the server
        viewModelScope.launch {
            val response = chatRepository.getResponse(message)
            val updatedMessages = _uiState.value.messages + "Friend: $response"
            _uiState.value = _uiState.value.copy(messages = updatedMessages)
        }
    }
}
