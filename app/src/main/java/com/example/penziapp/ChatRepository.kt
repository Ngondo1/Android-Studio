package com.example.penziapp.ui

import com.example.penziapp.network.ChatApiService
import javax.inject.Inject

class ChatRepository @Inject constructor(private val chatApiService: ChatApiService) {

    suspend fun getResponse(message: String): String {
        return try {
            val response = chatApiService.sendMessage(message)
            response.reply ?: "No response"
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}
