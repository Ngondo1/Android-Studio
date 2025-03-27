package com.example.penziapp.ui.chat

sealed class ChatState {
    object Idle : ChatState()
    object Loading : ChatState()
    data class Success<T>(val data: T) : ChatState()
    data class Error(val message: String) : ChatState()
}