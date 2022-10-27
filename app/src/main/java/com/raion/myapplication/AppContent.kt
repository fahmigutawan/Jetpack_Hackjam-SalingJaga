package com.raion.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raion.myapplication.navigation.AppNavRoute
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

        composable(route = AppNavRoute.SplashScreen.name){

        }
    }
}