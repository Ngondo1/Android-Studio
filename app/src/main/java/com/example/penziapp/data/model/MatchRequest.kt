package com.example.penziapp.model

import java.sql.Timestamp

data class MatchesRequest(
    val matchID: Int,
    val requesterPhoneNo: String,
    val matchPhoneNo: String,
    val status: MatchStatus = MatchStatus.Pending,
    val requestTime: Timestamp?
)

enum class MatchStatus {
    Pending, Approved, Declined
}
