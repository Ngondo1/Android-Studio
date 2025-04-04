package com.example.penziapp.data.repository

import com.example.penziapp.api.AddUserRequest
import com.example.penziapp.api.ApiService
import com.example.penziapp.api.MatchRequest
import com.example.penziapp.api.MessageRequest
import com.example.penziapp.api.NextFormRequest
import com.example.penziapp.api.PhoneNumberRequest
import com.example.penziapp.api.RegistrationRequest
import com.example.penziapp.api.SelfDescriptionRequest
import com.example.penziapp.api.UserDetailsRequest
import com.example.penziapp.ui.chat.ChatIntent
import com.example.penziapp.ui.chat.ChatState
import retrofit2.Response
import javax.inject.Inject

class ChatRepository @Inject constructor(private val apiService: ApiService) {

    // Submit Phone Number
    suspend fun submitPhoneNumber(phoneData: PhoneNumberRequest): ChatState {
        return safeApiCall { apiService.submitPhoneNumber(phoneData) }
    }

    // Submit User Details
    suspend fun submitUserDetails(userDetails: UserDetailsRequest): ChatState {
        return safeApiCall { apiService.submitUserDetails(userDetails) }
    }

    // Submit Self Description
    suspend fun submitSelfDescription(descriptionData: SelfDescriptionRequest): ChatState {
        return safeApiCall { apiService.submitSelfDescription(descriptionData) }
    }

    // Submit Registration Details
    suspend fun submitDetailsReg(registrationData: RegistrationRequest): ChatState {
        return safeApiCall { apiService.submitDetailsReg(registrationData) }
    }

    // Submit Additional Form Data
    suspend fun submitNextForm(formData: NextFormRequest): ChatState {
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
    suspend fun addUser(userData: AddUserRequest): ChatState {
        return safeApiCall { apiService.addUser(userData) }
    }

    // Add New Message
    suspend fun addMessage(messageData: MessageRequest): ChatState {
        return safeApiCall { apiService.addMessage(messageData) }
    }

    // Fetch User Description
    suspend fun getUserDescription(userId: String): ChatState {
        return safeApiCall { apiService.getDescription(userId) }
    }

    // Get Matches with Pagination
    suspend fun getMatches(county: String, ageBracket: String, page: Int, limit: Int): ChatState {
        return safeApiCall { apiService.getMatches(county, ageBracket, page, limit) }
    }

    // Submit Match Request
    suspend fun requestMatch(matchData: MatchRequest): ChatState {
        return safeApiCall { apiService.requestMatch(matchData) }
    }

    // Update Match Request Status
    suspend fun updateMatchRequest(requestData: ChatIntent.UpdateMatchRequest): ChatState {
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
