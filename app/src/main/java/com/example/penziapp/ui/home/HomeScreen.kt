package com.example.penziapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to Penzi App!")

        Spacer(modifier = Modifier.height(24.dp))

        // Navigate to Chat Screen
        Button(onClick = { navController.navigate("chat") }) {
            Text("Go to Chat")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Navigate to Profile Screen
        Button(onClick = { navController.navigate("profile") }) {
            Text("Go to Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
