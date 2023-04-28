package com.example.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screens.main.LessonsMainScreen

sealed class LessonsScreens(
    val route: String,
) {
    object LessonsMainScreen : LessonsScreens("lessons_main")
}

fun NavGraphBuilder.lessonsScreens(navController: NavHostController) {
    composable(LessonsScreens.LessonsMainScreen.route) { LessonsMainScreen(navController) }
}
