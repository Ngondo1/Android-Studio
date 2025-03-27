package com.example.penziapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _chatState = MutableStateFlow<ChatState>(ChatState.Idle)
    val chatState: StateFlow<ChatState> = _chatState

    fun handleIntent(intent: ChatIntent) {
        viewModelScope.launch {
            _chatState.value = ChatState.Loading
            _chatState.value = when (intent) {
                is ChatIntent.SubmitPhoneNumber -> repository.submitPhoneNumber(intent.phoneData)
                is ChatIntent.SubmitUserDetails -> repository.submitUserDetails(intent.userDetails)
                is ChatIntent.SubmitSelfDescription -> repository.submitSelfDescription(intent.descriptionData)
                is ChatIntent.SubmitDetailsReg -> repository.submitDetailsReg(intent.registrationData)
                is ChatIntent.FetchFirstMessage -> repository.fetchFirstMessage()
                is ChatIntent.FetchMessageById -> repository.fetchMessageById(intent.messageId)
                is ChatIntent.SubmitNextForm -> repository.submitNextForm(intent.formData)
                is ChatIntent.AddUser -> repository.addUser(intent.userData)
                is ChatIntent.AddMessage -> repository.addMessage(intent.messageData)
                is ChatIntent.GetUserDescription -> repository.getUserDescription(intent.userId)
                is ChatIntent.GetMatches -> repository.getMatches(intent.county, intent.ageBracket, intent.page, intent.limit)
                is ChatIntent.RequestMatch -> repository.requestMatch(intent.matchData)
                is ChatIntent.UpdateMatchRequest -> repository.updateMatchRequest(intent.requestData)
                is ChatIntent.GetMatchRequests -> repository.getMatchRequests(intent.phoneNo)
            }
        }
    }
}

