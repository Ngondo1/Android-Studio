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



