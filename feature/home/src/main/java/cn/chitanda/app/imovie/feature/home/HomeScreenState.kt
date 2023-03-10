package cn.chitanda.app.imovie.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import cn.chitanda.app.imovie.feature.home.navigation.TopLevelDestination

/**
 * @author: Chen
 * @createTime: 2023/2/3 15:54
 * @description:
 **/
@Stable
class HomeScreenState(
    private val navController: NavController,
) {

    val showTopAppBar: Boolean
        @Composable get() = currentTopLevelDestination == TopLevelDestination.RecentlyUpdate
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            TopLevelDestination.RecentlyUpdate.route -> TopLevelDestination.RecentlyUpdate
            TopLevelDestination.History.route -> TopLevelDestination.History
            TopLevelDestination.Search.route -> TopLevelDestination.Search
            TopLevelDestination.Setting.route -> TopLevelDestination.Setting
            else -> null
        }
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()
    fun navigationToTopLevelDestination(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberHomeScreenState(
    navController: NavController,
): HomeScreenState {
    return remember(navController) {
        HomeScreenState(navController)
    }
}