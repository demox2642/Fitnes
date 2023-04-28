package com.example.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screens.main.AddMainScreen

sealed class AddScreens(
    val route: String,
) {
    object AddMainScreen : AddScreens("add_main")
}

fun NavGraphBuilder.addScreens(navController: NavHostController) {
    composable(AddScreens.AddMainScreen.route) { AddMainScreen(navController) }
}
