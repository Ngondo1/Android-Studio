/* MainActivity.kt */

package com.example.penziapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.penziapp.ui.theme.PenziAppTheme
import com.example.penziapp.ui.ChatFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PenziAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Load the ChatFragment composable as the main view
                    ChatFragment(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/* ChatFragment.kt */

package com.example.penziapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ChatFragment(modifier: Modifier = Modifier, viewModel: ChatViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var message by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Chat messages display
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            uiState.messages.forEach { msg ->
                val isUser = msg.startsWith("You:")
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (isUser) Color.Blue.copy(alpha = 0.2f) else Color.Gray.copy(alpha = 0.2f))
                        .padding(8.dp)
                ) {
                    Text(text = msg)
                }
            }
        }

        // Message input and send button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            TextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type a message...") }
            )
            Button(
                onClick = {
                    if (message.isNotBlank()) {
                        viewModel.sendMessage(message)
                        message = ""
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Send")
            }
        }
    }
}


/* Notes:
- Implemented Hilt for dependency injection.
- Created ChatViewModel for managing chat logic and state.
- Created ChatRepository to simulate API communication.
- API integration can be done by replacing the simulated response in ChatRepository.
- Added appropriate state management using StateFlow.
*/
