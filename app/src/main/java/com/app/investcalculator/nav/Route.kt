package com.app.investcalculator.nav

import com.app.investcalculator.nav.AppDestinationsArgs.INVESTMENT

sealed class Screen(val name: String) {
    data object HomeScreen : Screen("home")
    data object MutualFundScreen : Screen("mutual_fund")
    data object SearchScreen : Screen("Search Screen")
    data object ProfileScreen : Screen("Profile Screen")
}

sealed class Route(val name: String) {
    data object HomeRoute : Route("${Screen.HomeScreen.name}")
    data object MutualFundRoute : Route("${Screen.MutualFundScreen.name}/{$INVESTMENT}")
    data object SearchRoute : Route("${Screen.SearchScreen.name}")
    data object ProfileRoute : Route("${Screen.ProfileScreen.name}")
}

object AppDestinationsArgs {
    const val INVESTMENT = "investment"
}
