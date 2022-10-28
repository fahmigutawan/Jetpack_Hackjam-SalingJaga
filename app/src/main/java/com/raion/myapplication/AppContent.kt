package com.raion.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.screen.*
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
            LoginScreen(navController = navController)
        }

        composable(route = AppNavRoute.RegisterScreen.name) {
            RegisterScreen(navController = navController)
        }
        composable(route = AppNavRoute.HomeScreen.name) {

        }
        composable(route = AppNavRoute.DamkarScreen.name) {
            PihakScreen(
                navController = navController,
                title = "damkar",
                image = R.drawable.damkar,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Dinas Pemadam Kebakaran"
            )
        }
        composable(route = AppNavRoute.PolisiScreen.name) {
            PihakScreen(
                navController = navController,
                title = "polisi",
                image = R.drawable.polisi,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Kantor Polisi XYZ"
            )
        }
        composable(route = AppNavRoute.RumahSakitScreen.name) {
            PihakScreen(
                navController = navController,
                title = "ambulans",
                image = R.drawable.rumahsakit,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Rumah Sakit ABC"
            )
        }
    }
}
