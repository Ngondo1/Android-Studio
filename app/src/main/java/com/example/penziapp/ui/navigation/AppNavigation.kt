package com.example.penziapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.penziapp.ui.chat.ChatScreen
import com.example.penziapp.ui.home.HomeScreen
import com.example.penziapp.ui.profile.ProfileScreen

// Define routes for easy management
sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Chat : Screen("chat")
    data object Profile : Screen("profile")
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        // Home Screen
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        // Chat Screen
        composable(Screen.Chat.route) {
            ChatScreen(navController)
        }

        // Profile Screen
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
