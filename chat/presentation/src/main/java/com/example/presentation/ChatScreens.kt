package com.example.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screens.main.ChatMainScreen

sealed class ChatScreens(
    val route: String,
) {
    object ChatMainScreen : ChatScreens("chat_main")
}

fun NavGraphBuilder.chatScreens(navController: NavHostController) {
    composable(ChatScreens.ChatMainScreen.route) { ChatMainScreen(navController) }
}
