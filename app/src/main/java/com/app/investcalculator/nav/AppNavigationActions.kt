package com.app.investcalculator.nav

import androidx.navigation.NavHostController
import com.app.investcalculator.data.model.Investment

class AppNavigationActions(private val navController: NavHostController)    {
    fun navigateToMutualFundScreen(investment: Investment) {
        navController.navigate("${Screen.MutualFundScreen.name}/${CustomNavType(Investment.serializer()).serializeAsValue(investment)}") {
            launchSingleTop = true
        }

    }

    fun back() {
        navController.navigateUp()
    }

    fun navigateBottomNav(route: String) {
        navController.navigate(route) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }

            popUpTo(navController.graph.id) { inclusive = true }

            launchSingleTop = true
           // restoreState = true
        }
    }

}



