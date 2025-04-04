package com.example.penziapp.ui.chat

import com.example.penziapp.api.AddUserRequest
import com.example.penziapp.api.MatchRequest
import com.example.penziapp.api.MessageRequest
import com.example.penziapp.api.NextFormRequest
import com.example.penziapp.api.PhoneNumberRequest
import com.example.penziapp.api.RegistrationRequest
import com.example.penziapp.api.SelfDescriptionRequest
import com.example.penziapp.api.UserDetailsRequest

sealed class ChatIntent {
    data class SubmitPhoneNumber(val phoneData: PhoneNumberRequest) : ChatIntent()
    data class SubmitUserDetails(val userDetails: UserDetailsRequest) : ChatIntent()
    data class SubmitSelfDescription(val descriptionData: SelfDescriptionRequest) : ChatIntent()
    data class SubmitDetailsReg(val registrationData: RegistrationRequest) : ChatIntent()
    object FetchFirstMessage : ChatIntent()
    data class FetchMessageById(val messageId: Int) : ChatIntent()
    data class SubmitNextForm(val formData: NextFormRequest) : ChatIntent()
    data class AddUser(val userData: AddUserRequest) : ChatIntent()
    data class AddMessage(val messageData: MessageRequest) : ChatIntent()
    data class GetUserDescription(val userId: String) : ChatIntent()
    data class GetMatches(val county: String, val ageBracket: String, val page: Int, val limit: Int) : ChatIntent()
    data class RequestMatch(val matchData: MatchRequest) : ChatIntent()
    data class UpdateMatchRequest(val requestData: UpdateMatchRequest) : ChatIntent()
    data class GetMatchRequests(val phoneNo: String) : ChatIntent()
}
