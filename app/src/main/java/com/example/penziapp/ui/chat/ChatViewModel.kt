package com.example.penziapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.penziapp.data.model.ApiState
import com.example.penziapp.data.repository.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    // StateFlow to track API state
    private val _apiState = MutableStateFlow<ApiState>(ApiState.Idle)
    val apiState: StateFlow<ApiState> = _apiState

    // Function to submit phone number
    fun submitPhoneNumber(phoneData: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.submitPhoneNumber(phoneData)
        }
    }

    // Function to submit user details
    fun submitUserDetails(userDetails: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.submitUserDetails(userDetails)
        }
    }

    // Function to submit self-description
    fun submitSelfDescription(descriptionData: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.submitSelfDescription(descriptionData)
        }
    }

    // Function to submit registration details
    fun submitDetailsReg(registrationData: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.submitDetailsReg(registrationData)
        }
    }

    // Function to fetch a welcome message
    fun fetchFirstMessage() {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.fetchFirstMessage()
        }
    }

    // Function to fetch message with ID 7
    fun fetchMessage7() {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.fetchMessage7()
        }
    }

    // Function to submit additional form data
    fun submitNextForm(formData: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.submitNextForm(formData)
        }
    }

    // Function to fetch message by ID
    fun fetchMessageById(messageId: Int) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.fetchMessageById(messageId)
        }
    }

    // Function to add a user
    fun addUser(userData: Map<String, String?>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.addUser(userData)
        }
    }

    // Function to add a message
    fun addMessage(messageData: Map<String, Any>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.addMessage(messageData)
        }
    }

    // Function to get user description
    fun getUserDescription(userId: Int) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.getUserDescription(userId)
        }
    }

    // Function to get matches with pagination
    fun getMatches(county: String, ageBracket: String, page: Int, limit: Int) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.getMatches(county, ageBracket, page, limit)
        }
    }

    // Function to request a match
    fun requestMatch(matchData: Map<String, String>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.requestMatch(matchData)
        }
    }

    // Function to update match request status
    fun updateMatchRequest(requestData: Map<String, Any>) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.updateMatchRequest(requestData)
        }
    }

    // Function to get match requests
    fun getMatchRequests(phoneNo: String) {
        viewModelScope.launch {
            _apiState.value = ApiState.Loading
            _apiState.value = repository.getMatchRequests(phoneNo)
        }
    }
}
