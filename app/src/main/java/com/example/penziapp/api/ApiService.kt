package com.example.penziapp.api

//import com.example.penziapp.data.model.MessageResponse
//import com.example.penziapp.data.model.UserDescriptionResponse
//import com.example.penziapp.data.model.MatchResponse
//import com.example.penziapp.data.model.MatchRequestsResponse
import retrofit2.Response
import retrofit2.http.*

// Add the respective response models  for the requests according to your API


interface ApiService {

    // Submit phone number to create a user
    @POST("/submit_phone_number")
    fun submitPhoneNumber(@Body phoneData: Map<String, String>): Response<Void>

    // Submit user details
    @POST("/submit_user_details")
    fun submitUserDetails(@Body userDetails: Map<String, String>): Response<Void>

    // Submit self-description
    @POST("/submit_self_desc")
    fun submitSelfDescription(@Body descriptionData: Map<String, String>): Response<Void>

    // Submit registration details
    @POST("/submit_details_reg")
    fun submitDetailsReg(@Body registrationData: Map<String, String>): Response<Void>

    // Submit additional form data
    @POST("/submit_next_form")
    fun submitNextForm(@Body formData: Map<String, String>): Response<Void>

    // Fetch a specific message
    @GET("/get_message_by_id")
    fun getMessageById(@Query("messageID") messageId: Int = 5): Response<Void>

    // Fetch the first message (Welcome Message)
    @GET("/get_firstmessage")
    fun getFirstMessage(): Response<Void>

    // Fetch a specific message with messageID=7
    @GET("/get_message_7")
    fun getMessage7(): Response<Void>

    // Add a new user
    @POST("/add_user")
    fun addUser(@Body userData: Map<String, String?>): Response<Void>

    // Add a new message
    @POST("/add_message")
    fun addMessage(@Body messageData: Map<String, Any>): Response<Void>

    // Fetch user description
    @GET("/get_description")
    fun getUserDescription(@Query("userID") userId: Int): Response<Void>

    // Get potential matches with pagination
    @GET("/get_matches")
    fun getMatches(
        @Query("county") county: String,
        @Query("ageBracket") ageBracket: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<Void>

    // Submit a match request
    @POST("/request_match")
    fun requestMatch(@Body matchData: Map<String, String>): Response<Void>

    // Update a match request status
    @POST("/update_match_request")
    fun updateMatchRequest(@Body requestData: Map<String, Any>): Response<Void>

    // Get match requests
    @GET("/get_match_requests")
    fun getMatchRequests(@Query("phoneNo") phoneNo: String): Response<Void>
}
