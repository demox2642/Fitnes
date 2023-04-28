package com.example.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.presentation.screens.main.MoreMainScreen

sealed class MoreScreens(
    val route: String,
) {
    object MoreMain : MoreScreens("more_main")
}

fun NavGraphBuilder.moreScreens(navController: NavHostController) {
    composable(MoreScreens.MoreMain.route) { MoreMainScreen(navController) }
}
