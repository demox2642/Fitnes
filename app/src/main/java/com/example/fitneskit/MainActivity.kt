package com.example.fitneskit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fitneskit.ui.screens.BottomNavScreens
import com.example.fitneskit.ui.screens.bottomNavScreens
import com.example.fitneskit.ui.theme.FitnesKitTheme
import com.example.presentation.addScreens
import com.example.presentation.applicationsScreens
import com.example.presentation.chatScreens
import com.example.presentation.lessonsScreens
import com.example.presentation.moreScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FitnesKitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainContent()
                }
            }
        }
    }
}

val showNavBar = listOf(
    BottomNavScreens.Lessons,
    BottomNavScreens.Applications,
    BottomNavScreens.Add,
    BottomNavScreens.Chat,
    BottomNavScreens.More,
).map { it.route }

@Composable
fun BottomNav(navController: NavHostController) {
    val items = listOf(
        BottomNavScreens.Lessons,
        BottomNavScreens.Applications,
        BottomNavScreens.Add,
        BottomNavScreens.Chat,
        BottomNavScreens.More,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (currentDestination?.route in showNavBar) {
        BottomNavigation(

            backgroundColor = Color.LightGray.copy(0.4f),
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 0.dp,

        ) {
            items.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = screen.iconId), contentDescription = null, modifier = Modifier.size(30.dp)) },
                    label = {
                        Text(
                            stringResource(screen.resourceId),
                            maxLines = 1,
                        )
                    },
                    selectedContentColor = Color(0xFF6524F8),
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNav(navController) },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavScreens.Lessons.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            bottomNavScreens(navController)
            chatScreens(navController)
            applicationsScreens(navController)
            lessonsScreens(navController)
            moreScreens(navController)
            addScreens(navController)
        }
    }
}
