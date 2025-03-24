package com.example.penziapp.models

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// =======================
// Database Models
// These models represent the database tables and map to their respective columns.
// =======================
data class Message(
    val messageID: Int,
    val shortCode: Int?,
    val sendTime: Timestamp?,
    val phoneNo: String,
    val message: String,
    val messageType: MessageType
)

// Enum for message types (User or System-generated messages)
enum class MessageType {
    User, System
}

data class User(
    val userID: Int,
    val registrationTime: Date?,
    val name: String?,
    val age: Int?,
    val phoneNo: String,
    val gender: String?,
    val county: String?,
    val town: String?,
    val levelOfEducation: String?,
    val profession: String?,
    val maritalStatus: String?,
    val religion: String?,
    val ethnicity: String?,
    val description: String?
)

// Represents a match request between users
data class MatchRequestModel(
    val matchID: Int,
    val requesterPhoneNo: String,
    val matchPhoneNo: String,
    val status: MatchStatus,
    val requestTime: Timestamp?
)

// Enum for match request status
enum class MatchStatus {
    Pending, Approved, Declined
}

// =======================
// API Response Wrappers
// These are used to handle API responses and errors in a clean and structured way.
// =======================
sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val error: ErrorResponse) : ApiResponse<Nothing>()
}

// Represents error responses from API calls
data class ErrorResponse(
    val error: Boolean,
    val message: String
)

// =======================
// API Request Models
// These models are used to send data to API endpoints when making HTTP requests.
// =======================
data class SubmitPhoneNumberRequest(
    val phoneNo: String
)

data class SubmitSelfDescriptionRequest(
    val description: String,
    val phoneNo: String
)

data class SubmitUserDetailsRequest(
    val name: String,
    val age: Int,
    val gender: String,
    val county: String,
    val town: String,
    val phoneNo: String
)

// Model for submitting a match request
data class MatchRequest(
    val requesterPhoneNo: String,
    val matchPhoneNo: String
)

// Model for updating a match request status
data class UpdateMatchRequest(
    val matchID: Int,
    val status: MatchStatus
)

// =======================
// Utility Functions
// Helpful functions for model operations
// =======================
fun Timestamp.toFormattedString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(Date(this.time))
}
