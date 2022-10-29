package com.raion.myapplication

import androidx.compose.runtime.Composable
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
            HomeScreen(navController = navController)
        }
        composable(route = AppNavRoute.ProfileScreen.name) {
            ProfileScreen(navController = navController)
        }
        composable(route = AppNavRoute.SettingsScreen.name) {
            SettingsScreen(navController = navController)
        }
        composable(route = AppNavRoute.MyProfileScreen.name) {
            MyProfileScreen(navController = navController)
        }
        composable(route = AppNavRoute.AboutUsScreen.name) {
            AboutUsScreen(navController = navController)
        }
        composable(route = AppNavRoute.PrivacyPolicyScreen.name) {
            PrivacyPolicyScreen(navController = navController)
        }
        composable(route = AppNavRoute.TermsConditionScreen.name) {
            TermsConditionScreen(navController = navController)
        }
        composable(route = AppNavRoute.DamkarScreen.name) {
            PihakScreen(
                navController = navController,
                title = "Damkar",
                image = R.drawable.img_damkar,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Dinas Pemadam Kebakaran"
            )
        }
        composable(route = AppNavRoute.PolisiScreen.name) {
            PihakScreen(
                navController = navController,
                title = "Polisi",
                image = R.drawable.img_polisi,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Kantor Polisi XYZ"
            )
        }
        composable(route = AppNavRoute.RumahSakitScreen.name) {
            PihakScreen(
                navController = navController,
                title = "Ambulans",
                image = R.drawable.img_rumahsakit,
                buka = "07.00-23.00",
                alamat = "Jl. Binkil no.1",
                dinas = "Rumah Sakit ABC"
            )
        }
    }
}
