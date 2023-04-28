package com.example.fitneskit.ui.screens // ktlint-disable package-name

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.fitnes_kit.R
import com.example.presentation.screens.main.AddMainScreen
import com.example.presentation.screens.main.ApplicationsMainScreen
import com.example.presentation.screens.main.ChatMainScreen
import com.example.presentation.screens.main.LessonsMainScreen
import com.example.presentation.screens.main.MoreMainScreen

sealed class BottomNavScreens(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val resourceId: Int,
) {
    object Lessons : BottomNavScreens("lessons_menu", R.drawable.ic_lessons, R.string.app_menu_lessons)
    object Applications : BottomNavScreens("applications_menu", R.drawable.ic_applications, R.string.app_menu_applications)
    object Add : BottomNavScreens("add_menu", R.drawable.ic_add, R.string.app_menu_add)
    object Chat : BottomNavScreens("chat_menu", R.drawable.ic_chat, R.string.app_menu_chat)
    object More : BottomNavScreens("more_menu", R.drawable.ic_more, R.string.app_menu_more)
}

fun NavGraphBuilder.bottomNavScreens(navController: NavHostController) {
    composable(BottomNavScreens.Lessons.route) { LessonsMainScreen(navController) }
    composable(BottomNavScreens.Applications.route) { ApplicationsMainScreen(navController) }
    composable(BottomNavScreens.Add.route) { AddMainScreen(navController) }
    composable(BottomNavScreens.Chat.route) { ChatMainScreen(navController) }
    composable(BottomNavScreens.More.route) { MoreMainScreen(navController) }
}
