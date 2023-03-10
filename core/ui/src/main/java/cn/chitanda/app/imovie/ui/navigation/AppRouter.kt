package cn.chitanda.app.imovie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

/**
 * @author: Chen
 * @createTime: 2023/2/3 10:01
 * @description:
 **/
@Composable
fun AppRouter(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    vararg navigationRegisters: ProvidedValue<*>,
    startDestination: String,
    builder: NavGraphBuilder.() -> Unit,
) {
    CompositionLocalProvider(
        LocalNavController provides navController,
        *navigationRegisters
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination,
            builder = builder
        )
    }
}