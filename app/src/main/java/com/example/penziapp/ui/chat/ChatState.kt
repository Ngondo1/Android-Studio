package com.example.penziapp.ui.chat

data class ChatState(
    val isLoading: Boolean = false,
    val messages: List<String> = emptyList(),
    val errorMessage: String? = null
)
