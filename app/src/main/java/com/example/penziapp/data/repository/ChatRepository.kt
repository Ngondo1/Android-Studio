package com.example.penziapp.data.repository

import com.example.penziapp.api.ApiService
import com.example.penziapp.data.model.*
import javax.inject.Inject

class ChatRepository @Inject constructor(private val apiService: ApiService) {

    // Submit Phone Number
    suspend fun submitPhoneNumber(phoneData: Map<String, String>): ApiState {
        return try {
            val response = apiService.submitPhoneNumber(phoneData)
            if (response.isExecuted) {
                ApiState.Success("Phone number submitted successfully")
            } else {
                ApiState.Error("Failed to submit phone number")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Submit User Details
    suspend fun submitUserDetails(userDetails: Map<String, String>): ApiState {
        return try {
            val response = apiService.submitUserDetails(userDetails)
            if (response.isExecuted) {
                ApiState.Success("User details submitted successfully")
            } else {
                ApiState.Error("Failed to submit user details")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Submit Self Description
    suspend fun submitSelfDescription(descriptionData: Map<String, String>): ApiState {
        return try {
            val response = apiService.submitSelfDescription(descriptionData)
            if (response.isExecuted) {
                ApiState.Success("Self-description submitted successfully")
            } else {
                ApiState.Error("Failed to submit self-description")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Submit Registration Details
    suspend fun submitDetailsReg(registrationData: Map<String, String>): ApiState {
        return try {
            val response = apiService.submitDetailsReg(registrationData)
            if (response.isExecuted) {
                ApiState.Success("Registration details submitted successfully")
            } else {
                ApiState.Error("Failed to submit registration details")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Submit Additional Form Data
    suspend fun submitNextForm(formData: Map<String, String>): ApiState {
        return try {
            val response = apiService.submitNextForm(formData)
            if (response.isExecuted) {
                ApiState.Success("Form data submitted successfully")
            } else {
                ApiState.Error("Failed to submit form data")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Fetch Message by ID
    suspend fun fetchMessageById(messageId: Int = 5): ApiState {
        return try {
            val response = apiService.getMessageById(messageId)
            if (response.isSuccessful) {
                ApiState.Success(response.body()?.message ?: "No message found")
            } else {
                ApiState.Error("Failed to fetch message")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Fetch First (Welcome) Message
    suspend fun fetchFirstMessage(): ApiState {
        return try {
            val response = apiService.getFirstMessage()
            if (response.isSuccessful) {
                ApiState.Success(response.body()?.message ?: "Welcome message not found")
            } else {
                ApiState.Error("Failed to fetch welcome message")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Fetch Message with ID = 7
    suspend fun fetchMessage7(): ApiState {
        return try {
            val response = apiService.getMessage7()
            if (response.isSuccessful) {
                ApiState.Success(response.body()?.message ?: "Message not found")
            } else {
                ApiState.Error("Failed to fetch message 7")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Add New User
    suspend fun addUser(userData: Map<String, String?>): ApiState {
        return try {
            val response = apiService.addUser(userData)
            if (response.isExecuted) {
                ApiState.Success("User added successfully")
            } else {
                ApiState.Error("Failed to add user")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Add New Message
    suspend fun addMessage(messageData: Map<String, Any>): ApiState {
        return try {
            val response = apiService.addMessage(messageData)
            if (response.isExecuted) {
                ApiState.Success("Message added successfully")
            } else {
                ApiState.Error("Failed to add message")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Fetch User Description
    suspend fun getUserDescription(userId: Int): ApiState {
        return try {
            val response = apiService.getUserDescription(userId)
            if (response.isSuccessful) {
                ApiState.Success(response.body()?.description ?: "No description available")
            } else {
                ApiState.Error("Failed to fetch user description")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Get Matches with Pagination
    suspend fun getMatches(county: String, ageBracket: String, page: Int, limit: Int): ApiState {
        return try {
            val response = apiService.getMatches(county, ageBracket, page, limit)
            if (response.isSuccessful) {
                ApiState.Success("Matches fetched successfully")
            } else {
                ApiState.Error("Failed to fetch matches")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Submit Match Request
    suspend fun requestMatch(matchData: Map<String, String>): ApiState {
        return try {
            val response = apiService.requestMatch(matchData)
            if (response.isExecuted) {
                ApiState.Success("Match request submitted successfully")
            } else {
                ApiState.Error("Failed to submit match request")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Update Match Request Status
    suspend fun updateMatchRequest(requestData: Map<String, Any>): ApiState {
        return try {
            val response = apiService.updateMatchRequest(requestData)
            if (response.isExecuted) {
                ApiState.Success("Match request updated successfully")
            } else {
                ApiState.Error("Failed to update match request")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }

    // Fetch Match Requests
    suspend fun getMatchRequests(phoneNo: String): ApiState {
        return try {
            val response = apiService.getMatchRequests(phoneNo)
            if (response.isSuccessful) {
                ApiState.Success("Match requests fetched successfully")
            } else {
                ApiState.Error("Failed to fetch match requests")
            }
        } catch (e: Exception) {
            ApiState.Error("Error: ${e.localizedMessage}")
        }
    }
}
