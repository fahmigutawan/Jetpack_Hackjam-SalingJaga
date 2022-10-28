package com.raion.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.screen.LandingScreen
import com.raion.myapplication.screen.SplashScreen
import com.raion.myapplication.viewmodel.MainViewModel

@Composable
fun AppContent(
    navController: NavHostController,
    mainViewModel: MainViewModel
) {
    NavHost(navController = navController, startDestination = AppNavRoute.SplashScreen.name) {
        //Called like this:
        /**composables(
        route = "New Route, you can define this on AppNavRoute enum file at ./navigation/AppNavRoute.kt"
        ){
        You code the screen here
        }*/

        composable(route = AppNavRoute.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(route = AppNavRoute.LandingScreen.name) {
            LandingScreen(navController = navController)
        }

        composable(route = AppNavRoute.LoginScreen.name) {

        }

        composable(route = AppNavRoute.RegisterScreen.name) {

        }
        composable(route = AppNavRoute.HomeScreen.name) {

        }
    }
}