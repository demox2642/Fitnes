package com.example.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screens.main.ApplicationsMainScreen

sealed class ApplicationsScreens(
    val route: String,
) {
    object ApplicationsMainScreen : ApplicationsScreens("application_main")
}

fun NavGraphBuilder.applicationsScreens(navController: NavHostController) {
    composable(ApplicationsScreens.ApplicationsMainScreen.route) { ApplicationsMainScreen(navController) }
}
