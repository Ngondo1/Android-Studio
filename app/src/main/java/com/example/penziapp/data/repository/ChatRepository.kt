package com.example.penziapp.repository

import com.example.penziapp.api.ApiService
import com.example.penziapp.data.model.*
import retrofit2.Response
import javax.inject.Inject

class ChatRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun submitPhoneNumber(phoneData: Map<String, String>): Response<Void> {
        return apiService.submitPhoneNumber(phoneData)
    }

    suspend fun submitUserDetails(userDetails: Map<String, String>): Response<Void> {
        return apiService.submitUserDetails(userDetails)
    }

    suspend fun submitSelfDescription(descriptionData: Map<String, String>): Response<Void> {
        return apiService.submitSelfDescription(descriptionData)
    }

    suspend fun submitDetailsReg(registrationData: Map<String, String>): Response<Void> {
        return apiService.submitDetailsReg(registrationData)
    }

    suspend fun submitNextForm(formData: Map<String, String>): Response<Void> {
        return apiService.submitNextForm(formData)
    }

    suspend fun getMessageById(messageId: Int = 5): Response<MessageResponse> {
        return apiService.getMessageById(messageId)
    }

    suspend fun getFirstMessage(): Response<MessageResponse> {
        return apiService.getFirstMessage()
    }

    suspend fun getMessage7(): Response<MessageResponse> {
        return apiService.getMessage7()
    }

    suspend fun addUser(userData: Map<String, String?>): Response<Void> {
        return apiService.addUser(userData)
    }

    suspend fun addMessage(messageData: Map<String, Any>): Response<Void> {
        return apiService.addMessage(messageData)
    }

    suspend fun getUserDescription(userId: Int): Response<UserDescriptionResponse> {
        return apiService.getUserDescription(userId)
    }

    suspend fun getMatches(county: String, ageBracket: String, page: Int, limit: Int): Response<MatchResponse> {
        return apiService.getMatches(county, ageBracket, page, limit)
    }

    suspend fun requestMatch(matchData: Map<String, String>): Response<Void> {
        return apiService.requestMatch(matchData)
    }

    suspend fun updateMatchRequest(requestData: Map<String, Any>): Response<Void> {
        return apiService.updateMatchRequest(requestData)
    }

    suspend fun getMatchRequests(phoneNo: String): Response<MatchRequestsResponse> {
        return apiService.getMatchRequests(phoneNo)
    }
}
