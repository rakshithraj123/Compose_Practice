package com.app.investcalculator.ui.common

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.investcalculator.nav.BottomNavItem

@Composable
fun BottomNavBar(
    destinations: List<BottomNavItem>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (route: String) -> Unit,
    modifier: Modifier = Modifier
) {


        NavigationBar(
            modifier = modifier
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
                )
        ) {
            destinations.forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = { onNavigateToDestination(destination.route) },
                    icon = {
                        val icon = if (selected) {
                            destination.icon
                        } else {
                            destination.icon
                        }
                        Icon(
                            imageVector = icon,
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = destination.label
                        )
                    })
            }
        }


}






















//@Composable
//fun BottomNavBar(
//    navController: NavController
//    , navActions: AppNavigationActions,
//    modifier : Modifier = Modifier
//) {
//
//
//    val currentDestination by navController.currentBackStackEntryAsState()
//    CommonBottomAppBar(currentDestination?.destination?.route,navActions,
//        modifier
//    )
//
////    currentDestination?.destination?.route in listOf(
////        Route.HomeRoute.name,
////        Route.SearchRoute.name,
////        Route.ProfileRoute.name
////    )
////    val modifier : Modifier = Modifier
////    when (currentDestination?.destination?.route) {
////        in listOf(Route.HomeRoute.name,
////        Route.SearchRoute.name,
////        Route.ProfileRoute.name
////        )-> {
////
////
////        }
////        else -> {
////
////        }
////    }
//}
