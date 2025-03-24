package com.example.penziapp.ui.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.penziapp.data.model.ApiState

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel()
) {
    val context = LocalContext.current
    val apiState by viewModel.apiState.collectAsState()

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
            viewModel.submitPhoneNumber(mapOf("phoneNo" to phoneNumber))
        }) {
            Text("Submit Phone Number")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.addMessage(mapOf("phoneNo" to phoneNumber, "message" to message))
        }) {
            Text("Send Message")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Display API State
        when (apiState) {
            is ApiState.Idle -> Text("Waiting for input...")
            is ApiState.Loading -> CircularProgressIndicator()
            is ApiState.Success -> Text("Success: ${(apiState as ApiState.Success).message}")
            is ApiState.Error -> Text("Error: ${(apiState as ApiState.Error).error}", color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}
