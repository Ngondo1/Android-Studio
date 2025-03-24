package com.example.penziapp.models

// API State Management using Sealed Class
sealed class ApiState {
    object Idle : ApiState()
    object Loading : ApiState()
    data class Success(val message: String) : ApiState()
    data class Error(val error: String) : ApiState()
}
let