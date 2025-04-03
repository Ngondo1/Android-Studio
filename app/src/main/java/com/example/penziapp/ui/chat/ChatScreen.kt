package com.example.penziapp.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

//Note we are using hiltViewmodel and not viewmodel

@Composable
fun ChatScreen( navController: NavController, viewModel: ChatViewModel = hiltViewModel(),) {
    val context = LocalContext.current
    val chatState by viewModel.chatState.collectAsState()

    // UI State variables
    var phoneNumber by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Input for phone number
        BasicTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (phoneNumber.isEmpty()) {
                    Text("Enter Phone Number", color = Color.Gray)
                }
                innerTextField()
            }
        )

        // Input for message
        BasicTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                if (message.isEmpty()) {
                    Text("Enter Message", color = Color.Gray)
                }
                innerTextField()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(onClick = {
            viewModel.handleIntent(ChatIntent.SubmitPhoneNumber(mapOf("phoneNo" to phoneNumber)))
        }) {
            Text("Submit Phone Number")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.handleIntent(ChatIntent.AddMessage(mapOf("phoneNo" to phoneNumber, "message" to message)))
        }) {
            Text("Send Message")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Display Chat State
        when (chatState) {
            is ChatState.Idle -> Text("Waiting for input...")
            is ChatState.Loading -> CircularProgressIndicator()
            is ChatState.Success<*> -> Text("Success: ${(chatState as ChatState.Success<*>).data}")
            is ChatState.Error -> Text("Error: ${(chatState as ChatState.Error).message}", color = Color.Red)
        }
    }
}


