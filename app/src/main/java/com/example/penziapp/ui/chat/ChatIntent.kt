package com.example.penziapp.ui.chat
sealed class ChatIntent {
    data class SubmitPhoneNumber(val phoneData: Map<String, String>) : ChatIntent()
    data class SubmitUserDetails(val userDetails: Map<String, String>) : ChatIntent()
    data class SubmitSelfDescription(val descriptionData: Map<String, String>) : ChatIntent()
    data class SubmitDetailsReg(val registrationData: Map<String, String>) : ChatIntent()
    object FetchFirstMessage : ChatIntent()
    data class FetchMessageById(val messageId: Int) : ChatIntent()
    data class SubmitNextForm(val formData: Map<String, String>) : ChatIntent()
    data class AddUser(val userData: Map<String, String?>) : ChatIntent()
    data class AddMessage(val messageData: Map<String, Any>) : ChatIntent()
    data class GetUserDescription(val userId: Int) : ChatIntent()
    data class GetMatches(val county: String, val ageBracket: String, val page: Int, val limit: Int) : ChatIntent()
    data class RequestMatch(val matchData: Map<String, String>) : ChatIntent()
    data class UpdateMatchRequest(val requestData: Map<String, Any>) : ChatIntent()
    data class GetMatchRequests(val phoneNo: String) : ChatIntent()
}