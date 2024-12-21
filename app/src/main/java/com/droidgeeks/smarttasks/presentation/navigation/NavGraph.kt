package com.droidgeeks.smarttasks.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droidgeeks.smarttasks.presentation.details.DetailScreen
import com.droidgeeks.smarttasks.presentation.home.HomeScreen
import com.droidgeeks.smarttasks.presentation.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = NavScreen.Splash.route) {
        composable(
            route = NavScreen.Splash.route
        ) {
            SplashScreen(onGetStarted = {
                navController.navigate(NavRoutes.MAIN_SCREEN) {
                    popUpTo(NavRoutes.SPLASH_SCREEN) {
                        inclusive = true
                    }
                }
            })
        }
        composable(
            route = NavScreen.Main.route
        ) {
            HomeScreen(onClickItem = {
                navController.navigate(NavRoutes.DETAIL_SCREEN + "/${it.id}")
            })
        }

        composable(
            route = NavScreen.Detail.route + "/{id}"
        ) {
            val taskId = it.arguments?.getString("id")
            DetailScreen(taskId, onBackPressed = {
                navController.navigateUp()
            })
        }
    }

}