import retrofit2.Response
import retrofit2.http.*

// API service interface to handle requests for Users, Messages, and MatchesRequest
interface ApiService {

    /**
     * ----------------------------- USERS -----------------------------
     * Handles user creation, registration, description submission, and other user-related tasks.
     */

    // Submit phone number to create a new user
    @POST("/submit_phone_number")
    suspend fun submitPhoneNumber(@Body phoneData: Users): Response<Unit>

    // Submit user details like name, age, gender, and location
    @POST("/submit_user_details")
    suspend fun submitUserDetails(@Body userDetails: Users): Response<Unit>

    // Submit a self-description for the user's profile
    @POST("/submit_self_desc")
    suspend fun submitSelfDescription(@Body descriptionData: Users): Response<Unit>

    // Submit registration details (e.g., name, age, gender)
    @POST("/submit_details_reg")
    suspend fun submitDetailsReg(@Body registrationData: Users): Response<Unit>


    /**
     * ---------------------------- MESSAGES ----------------------------
     * Manage messages, including fetching, adding, and viewing system messages.
     */

    // Fetch a message using a specific message ID (default ID is 5)
    @GET("/get_message_by_id")
    suspend fun getMessageById(@Query("messageID") messageId: Int = 5): Response<Messages>

    // Fetch the first welcome message (message ID = 4)
    @GET("/get_firstmessage")
    suspend fun getFirstMessage(): Response<Messages>

    // Fetch a system-defined message with message ID = 7
    @GET("/get_message_7")
    suspend fun getMessage7(): Response<Messages>

    // Add a new message (can be a system or user message)
    @POST("/add_message")
    suspend fun addMessage(@Body messageData: Messages): Response<Unit>


    /**
     * ------------------------- MATCHES REQUEST -------------------------
     * Handles match requests, approvals, and retrieval of user matches.
     */

    // Retrieve potential matches for a user based on county and age bracket
    @GET("/get_matches")
    suspend fun getMatches(
        @Query("county") county: String,
        @Query("ageBracket") ageBracket: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<Users>>  // Returns a list of matching user profiles

    // Submit a match request from one user to another
    @POST("/request_match")
    suspend fun requestMatch(@Body matchData: MatchesRequest): Response<Unit>

    // Approve or decline a match request using matchID
    @POST("/update_match_request")
    suspend fun updateMatchRequest(@Body requestData: MatchesRequest): Response<Unit>

    // Fetch all match requests for a specific user by phone number
    @GET("/get_match_requests")
    suspend fun getMatchRequests(@Query("phoneNo") phoneNo: String): Response<List<MatchesRequest>>

    /**
     * ------------------------- USER DESCRIPTION -------------------------
     * Retrieve user descriptions when needed for profiles or matches.
     */

    // Fetch the user's self-description using their userID
    @GET("/get_description")
    suspend fun getUserDescription(@Query("userID") userId: Int): Response<Users>
}
