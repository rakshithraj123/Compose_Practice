package com.app.investcalculator.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Stable
class AppState(
    val navController: NavHostController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Profile
    )

    val bottomBarTabs = items
    private val bottomBarRoutes = bottomBarTabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomBarRoute(route: String) {
        if (route != currentRoute) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true
                popUpTo(navController.graph.id) {
                    saveState = true
                    inclusive = true
                }
            }
        }
    }
}

private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED


