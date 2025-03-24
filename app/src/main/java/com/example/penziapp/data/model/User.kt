package com.example.penziapp.model

import java.sql.Date

data class Users(
    val userID: Int,
    val registrationTime: Date?,
    val name: String?,
    val age: Int?,
    val phoneNo: String?,
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
