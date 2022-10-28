package com.raion.myapplication.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(navController: NavHostController) {
    /**Attrs*/
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    val viewModel = getViewModel<SplashViewModel>()

    /**Function*/
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)

        if(viewModel.userLoggedIn()){
            navController.navigate(route = AppNavRoute.HomeScreen.name) {
                popUpTo(route = AppNavRoute.SplashScreen.name) {
                    inclusive = true
                }
            }
        }else{
            navController.navigate(route = AppNavRoute.LandingScreen.name) {
                popUpTo(route = AppNavRoute.SplashScreen.name) {
                    inclusive = true
                }
            }
        }
    }

    /**Content*/
    SplashContent(alpha = alphaAnim.value)
}

@Composable
private fun SplashContent(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color(0, 48, 73))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "LOGO",
            modifier = Modifier
                .alpha(alpha = alpha),
            color = Color.White,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}