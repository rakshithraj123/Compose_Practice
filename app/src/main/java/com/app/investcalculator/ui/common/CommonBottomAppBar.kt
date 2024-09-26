//package com.app.investcalculator.ui.common
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.material3.Badge
//import androidx.compose.material3.BadgedBox
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.app.investcalculator.nav.AppNavigationActions
//import com.app.investcalculator.nav.BottomNavItem
//
//@Composable
//fun CommonBottomAppBar(
//    currentRoute: String?
//    , navActions: AppNavigationActions,
//    modifier : Modifier = Modifier
//) {
//
//    val items = listOf(
//        BottomNavItem.Home,
//        BottomNavItem.Search,
//        BottomNavItem.Profile
//    )
//    val selectedColor = Color.Blue
//    val unselectedColor = Color.Gray
//    val backgroundColor = Color.White  // Set your desired background color
//
//    val badgeCount = null
//    val hasNewUpdate = false
//
//   NavigationBar(
//            containerColor = backgroundColor, // Set the background color here
//            modifier = modifier
//                .background(Color.Black)
//                .height(56.dp)
//
//        ) {
//            items.forEach { item ->
//                val isSelected = currentRoute == item.route
//                NavigationBarItem(
//                    icon = {
//                        BadgedBox(
//                            badge = {
//
//                                if(badgeCount != null) {
//                                    Badge {
//                                        Text(text = badgeCount.toString())
//                                    }
//                                } else if(hasNewUpdate) {
//                                    Badge()
//                                }
//                            }
//                        ) {
//                            Icon(item.icon, contentDescription = item.label)
//                        }
//
//
//                    },
//                    label = { Text( text = item.label) },
//                    selected = isSelected,
//                    onClick = {
//                        navActions.navigateBottomNav(item.route)
//                    },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = selectedColor,
//                        unselectedIconColor = unselectedColor,
//                        selectedTextColor = selectedColor,
//                        unselectedTextColor = unselectedColor,
//                        indicatorColor = Color.Transparent // Optional: Customize indicator color or make it transparent
//
//                    ),
//                    modifier = Modifier
//                        .background(if (isSelected) Color.Green else Color.White)
//                        .defaultMinSize(minHeight = 56.dp)
//                )
//            }
//        }
//
//
//
//
//
//
//
//    //    BottomNavigation( modifier = Modifier.padding(bottom = 0.dp)) {
////        navItems.forEach { item ->
////            BottomNavigationItem(
////                icon = { Icon(item.icon, contentDescription = item.label) },
////                label = { Text(item.label) },
////                selected = currentRoute == item.route,
////                onClick = {
////                    if (currentRoute != item.route) {
////                        navController.navigate(item.route) {
////                            // Clear the back stack to avoid stacking up multiple instances of the same route
////                            //popUpTo(navController.graph.startDestinationId) { saveState = true }
////
////                            popUpTo(navController.graph.id) { inclusive = true }
////
////                            launchSingleTop = true
////                            restoreState = true
////                        }
////                    }
////                },
////                selectedContentColor = selectedColor,
////                unselectedContentColor = unselectedColor
////            )
////        }
////    }
//}