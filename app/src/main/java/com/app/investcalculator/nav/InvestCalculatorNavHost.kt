package com.app.investcalculator.nav

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.investcalculator.DetailScreen
import com.app.investcalculator.SettingsScreen
import com.app.investcalculator.data.model.Investment
import com.app.investcalculator.ui.SearchScreen
import com.app.investcalculator.ui.common.BottomNavBar
import com.app.investcalculator.ui.home.HomeScreen
import com.app.investcalculator.ui.mutalfund.MutualFundScreen
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay

val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Search,
    BottomNavItem.Profile
)

//@Composable
//fun InvestCalculatorNavHost() {
//    val navController = rememberNavController()
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    Scaffold(
//        bottomBar = {
//            // Show the bottom navigation bar only if not on the "detail" route
//            if (currentRoute != "detail") {
//                com.app.investcalculator.BottomNavBar(navController)
//            }
//        }
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = "home",
//            Modifier.padding(innerPadding)
//        ) {
//            composable("home") { com.app.investcalculator.HomeScreen(navController) }
//            composable("profile") { com.app.investcalculator.ProfileScreen() }
//            composable("settings") { SettingsScreen() }
//            composable(
//                "detail"
//            ) { backStackEntry ->
//                MutualFundScreen()
//            }
//        }
//    }
//}

@Composable
fun InvestCalculatorNavHost() {
    Log.d("**InvestCalculatorNavHost**", "***InvestCalculatorNavHost**")

    val navController =  rememberNavController()
    val navActions =   remember(navController) {
        AppNavigationActions(navController)
    }

    // val showBottomBar = remember { mutableStateOf(true) }
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
   // val navBackStackEntry by navController.currentBackStackEntryAsState()
   // val currentRoute = navBackStackEntry?.destination?.route

    LaunchedEffect(null) {
        Log.d("**InvestCalculatorNavHost**", "***LaunchedEffect**")

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val showBottomNavBar = destination?.route in listOf(
                Route.HomeRoute.name,
                Route.SearchRoute.name,
                Route.ProfileRoute.name
            )
            showBottomBar = showBottomNavBar
            Log.d("**InvestCalculatorNavHost**", "***showBottomNavBar** $showBottomNavBar")
        }
    }


    Scaffold(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding() // Ensures BottomNavBar respects system UI
        , topBar = {
            AppTopBar(navController, navActions)
        }, bottomBar = {
               if(showBottomBar)
                BottomNavBar(
                    destinations = items,
                    currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                    onNavigateToDestination = {

                        navController.navigate(it) {
                            popUpTo(navController.graph.id) {
                                // saveState = true
                                inclusive = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }, Modifier.height(70.dp)
                )



        }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavHost(navController,navActions = navActions)

        }

    }

    //setupDestinationListener(navController)
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    navActions: AppNavigationActions ,
    modifier: Modifier = Modifier,
) {

    Log.d("**InvestCalculatorNavHost**", "***AppNavHost**")
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.name,
        modifier = modifier
    ) {

        composable(Route.HomeRoute.name) {
            HomeScreen(navigateToMutualFundScreen = { investment ->
                navActions.navigateToMutualFundScreen(investment)
            })
        }

//        composable(
//            Route.MutualFundRoute.name, arguments = listOf(navArgument("investment") {
//                type = CustomNavType(Investment.serializer())
//            })
//        ) { backStackEntry ->
//            val investment = backStackEntry.arguments?.getString("investment")?.let {
//                CustomNavType(Investment.serializer()).parseValue(it)
//            }
//            MutualFundScreen(investment)
//        }
        composable(
            Route.MutualFundRoute.name,
        ) { backStackEntry ->

            MutualFundScreen()
        }

        composable(Route.SearchRoute.name) { SearchScreen() }

        composable(Route.ProfileRoute.name) { ProfileScreen() }
    }
}


@Composable
fun ProfileScreen() {
    // Content for Profile Screen
}

@Composable
fun shouldShowBottomNavBar(navController: NavController): Boolean {
    val currentDestination by navController.currentBackStackEntryAsState()
    return remember(currentDestination) {
        currentDestination?.destination?.route in listOf(
            Route.HomeRoute.name,
            Route.SearchRoute.name,
            Route.ProfileRoute.name
        )
    }
}

private fun setupDestinationListener(navController: NavController) {
    navController.addOnDestinationChangedListener { _, destination, _ ->
        val showBottomNavBar = destination?.route in listOf(
            Route.HomeRoute.name,
            Route.SearchRoute.name,
            Route.ProfileRoute.name
        )
    }
}



