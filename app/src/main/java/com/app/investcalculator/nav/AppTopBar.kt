package com.app.investcalculator.nav

import CommonTopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavController, navActions: AppNavigationActions,) {
//    var currentDestination by remember { mutableStateOf<String?>(null) }
//
//    // Update currentDestination whenever the back stack changes
//    LaunchedEffect(navController) {
//        navController.currentBackStackEntryFlow.collect { backStackEntry ->
//            currentDestination = backStackEntry.destination.route
//        }
//    }
    val currentDestination by navController.currentBackStackEntryAsState()


    when (currentDestination?.destination?.route) {
        Route.HomeRoute.name -> {
            CommonTopAppBar(
                title = "Home",
                showBackButton = false
            )
        }
        Route.MutualFundRoute.name -> {
            CommonTopAppBar(
                title = "MutualFund",
                showBackButton = true,
                onBackClick = {navActions.back()},
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                }
            )
        }
        Route.SearchRoute.name -> {
            CommonTopAppBar(
                title = "Search",
                showBackButton = false
            )
        }
        Route.ProfileRoute.name -> {
            CommonTopAppBar(
                title = "Profile",
                showBackButton = false
            )
        }
        else -> {
            // Default TopAppBar or a placeholder when the route is null
            CommonTopAppBar(
                title = "App",
                showBackButton = false
            )
        }
    }
}