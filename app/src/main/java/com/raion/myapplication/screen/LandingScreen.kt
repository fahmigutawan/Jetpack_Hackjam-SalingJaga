package com.raion.myapplication.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raion.myapplication.R
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.navigation.AppNavRoute

@Composable
fun LandingScreen(
    navController: NavController
) {
    /**Attrs*/
    val btnWidth = LocalConfiguration.current.screenWidthDp / 2

    /**Function*/

    /**Content*/
    LandingContent(
        btnWidth = btnWidth.dp,
        navController = navController
    )
}

@Composable
private fun LandingContent(
    btnWidth: Dp,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        //BG
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = R.drawable.ic_landing_background,
            contentDescription = "landing BG",
            contentScale = ContentScale.Crop
        )

        //Column
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Saling Jaga",
                    style = MaterialTheme.typography.h4,
                    color = Color.White
                )

                Text(
                    text = "Podo Malang e yo podo njaga ne",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
            }

            AppButtonField(
                modifier = Modifier.width(btnWidth),
                onClick = { navController.navigate(route = AppNavRoute.LoginScreen.name) }
            ) {
                Text(text = "Masuk", color = Color.White)
            }

            AppButtonField(
                modifier = Modifier.width(btnWidth),
                onClick = { /*TODO*/
                    navController.navigate(route = AppNavRoute.HomeScreen.name)
                }
            ) {
                Text(text = "Daftar", color = Color.White)
            }
        }
    }
}