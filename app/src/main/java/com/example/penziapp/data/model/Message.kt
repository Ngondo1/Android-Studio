package com.example.penziapp.model

import java.sql.Timestamp

data class Messages(
    val messageID: Int,
    val shortCode: Int?,
    val sendTime: Timestamp?,
    val phoneNo: String?,
    val message: String?,
    val messageType: MessageType
)

enum class MessageType {
    User, System
}
