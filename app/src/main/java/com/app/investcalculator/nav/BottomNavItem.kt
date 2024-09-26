package com.app.investcalculator.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem(Route.HomeRoute.name, Icons.Filled.Home, "Home")
    object Search : BottomNavItem(Route.SearchRoute.name, Icons.Filled.Search, "Search")
    object Profile : BottomNavItem(Route.ProfileRoute.name, Icons.Filled.Person, "Profile")
}

