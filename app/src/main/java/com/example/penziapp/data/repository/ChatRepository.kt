package com.example.penziapp.data.repository

import com.example.penziapp.api.ApiService
import com.example.penziapp.api.UserDetailsRequest
import com.example.penziapp.ui.chat.ChatState
import retrofit2.Response
import javax.inject.Inject

class ChatRepository @Inject constructor(private val apiService: ApiService) {

    // Submit Phone Number
    suspend fun submitPhoneNumber(phoneData: Map<String, String>): ChatState {
        return safeApiCall { apiService.submitPhoneNumber(phoneData) }
    }

    // Submit User Details
    suspend fun submitUserDetails(userDetails: UserDetailsRequest): ChatState {
        return safeApiCall { apiService.submitUserDetails(userDetails) }
    }

    // Submit Self Description
    suspend fun submitSelfDescription(descriptionData: Map<String, String>): ChatState {
        return safeApiCall { apiService.submitSelfDescription(descriptionData) }
    }

    // Submit Registration Details
    suspend fun submitDetailsReg(registrationData: Map<String, String>): ChatState {
        return safeApiCall { apiService.submitDetailsReg(registrationData) }
    }

    // Submit Additional Form Data
    suspend fun submitNextForm(formData: Map<String, String>): ChatState {
        return safeApiCall { apiService.submitNextForm(formData) }
    }

    // Fetch Message by ID
    suspend fun fetchMessageById(messageId: Int): ChatState {
        return safeApiCall { apiService.getMessageById(messageId) }
    }

    // Fetch First (Welcome) Message
    suspend fun fetchFirstMessage(): ChatState {
        return safeApiCall { apiService.getFirstMessage() }
    }

    // Fetch Message with ID = 7
    suspend fun fetchMessage7(): ChatState {
        return safeApiCall { apiService.getMessage7() }
    }

    // Add New User
    suspend fun addUser(userData: Map<String, String?>): ChatState {
        return safeApiCall { apiService.addUser(userData) }
    }

    // Add New Message
    suspend fun addMessage(messageData: Map<String, Any>): ChatState {
        return safeApiCall { apiService.addMessage(messageData) }
    }

    // Fetch User Description
    suspend fun getUserDescription(userId: Int): ChatState {
        return safeApiCall { apiService.getUserDescription(userId) }
    }

    // Get Matches with Pagination
    suspend fun getMatches(county: String, ageBracket: String, page: Int, limit: Int): ChatState {
        return safeApiCall { apiService.getMatches(county, ageBracket, page, limit) }
    }

    // Submit Match Request
    suspend fun requestMatch(matchData: Map<String, String>): ChatState {
        return safeApiCall { apiService.requestMatch(matchData) }
    }

    // Update Match Request Status
    suspend fun updateMatchRequest(requestData: Map<String, Any>): ChatState {
        return safeApiCall { apiService.updateMatchRequest(requestData) }
    }

    // Fetch Match Requests
    suspend fun getMatchRequests(phoneNo: String): ChatState {
        return safeApiCall { apiService.getMatchRequests(phoneNo) }
    }

    // Unified API Call Handling
    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): ChatState {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                ChatState.Success(response.body()?.toString() ?: "Success")
            } else {
                ChatState.Error("API Error: ${response.message()}")
            }
        } catch (e: Exception) {
            ChatState.Error("Exception: ${e.localizedMessage}")
        }
    }
}
