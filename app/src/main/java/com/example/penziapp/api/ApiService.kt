package com.example.penziapp.api

import com.example.penziapp.ui.chat.ChatIntent
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.Response

interface ApiService {

    @POST("/submit_self_desc")
    suspend fun submitSelfDescription(@Body request: SelfDescriptionRequest): Response<GenericResponse>

    @GET("/get_message_7")
    suspend fun getMessage7(): Response<MessageResponse>

    @POST("/submit_details_reg")
    suspend fun submitDetailsReg(@Body request: RegistrationRequest): Response<GenericResponse>

    @POST("/submit_user_details")
    suspend fun submitUserDetails(@Body request: UserDetailsRequest): Response<GenericResponse>

    @GET("/get_firstmessage")
    suspend fun getFirstMessage(): Response<MessageResponse>

    @POST("/submit_phone_number")
    suspend fun submitPhoneNumber(@Body request: PhoneNumberRequest): Response<GenericResponse>

    @POST("/add_user")
    suspend fun addUser(@Body request: AddUserRequest): Response<GenericResponse>

    @POST("/add_message")
    suspend fun addMessage(@Body request: MessageRequest): Response<GenericResponse>

    @GET("/get_message_by_id")
    suspend fun getMessageById(@Query("messageID") messageId: Int = 5): Response<MessageResponse>

    @POST("/submit_next_form")
    suspend fun submitNextForm(@Body request: NextFormRequest): Response<GenericResponse>

    @GET("/get_description")
    suspend fun getDescription(@Query("userID") userId: String): Response<DescriptionResponse>

    @GET("/get_matches")
    suspend fun getMatches(
        @Query("county") county: String,
        @Query("ageBracket") ageBracket: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<MatchesResponse>

    @POST("/request_match")
    suspend fun requestMatch(@Body request: MatchRequest): Response<GenericResponse>

    @POST("/update_match_request")
    suspend fun updateMatchRequest(@Body request: ChatIntent.UpdateMatchRequest): Response<GenericResponse>

    @GET("/get_match_requests")
    suspend fun getMatchRequests(@Query("phoneNo") phoneNo: String): Response<MatchRequestsResponse>
}

// Data classes for API requests and responses

data class SelfDescriptionRequest(val phoneNo: String, val description: String)
data class RegistrationRequest(val phoneNo: String, val additionalDetails: Map<String, String>)
data class UserDetailsRequest(val name: String, val age: Int, val gender: String, val county: String, val town: String, val phoneNo: String)
data class PhoneNumberRequest(val phoneNo: String)
data class AddUserRequest(val userDetails: Map<String, Any>)
data class MessageRequest(val messageID: Int, val shortCode: String, @SerializedName("SendTime") val sendTime: String, val phoneNo: String, val message: String, val messageType: String)
data class NextFormRequest(val formData: Map<String, String>)
data class MatchRequest(val requester_phoneNo: String, val match_phoneNo: String)
data class UpdateMatchRequest(val matchID: Int, val status: String)

data class GenericResponse(val success: Boolean, val message: String)
data class MessageResponse(val messageID: Int, val shortCode: String, @SerializedName("SendTime") val sendTime: String, val phoneNo: String, val message: String, val messageType: String)
data class DescriptionResponse(val userID: String, val description: String)
data class MatchesResponse(val matches: List<MatchItem>)
data class MatchItem(val matchID: Int, val name: String, val age: Int, val phoneNo: String, val county: String, val town: String)
data class MatchRequestsResponse(val requests: List<MatchRequestItem>)
data class MatchRequestItem(val matchID: Int, val requester_phoneNo: String, val match_phoneNo: String, val status: String, val request_time: String)
