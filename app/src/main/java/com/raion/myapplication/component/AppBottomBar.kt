package com.raion.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.BlueDark
import com.raion.myapplication.viewmodel.MainViewModel

@Composable
fun AppBottomBar(
    mainViewModel: MainViewModel,
    navController: NavController
) {
    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Home
            AppBottomBarItem.Home.let { item ->
                IconButton(onClick = { navController.navigate(route = item.route) }) {
                    Icon(
                        tint = if (mainViewModel.recentBottomBarRoute.equals(item.route)) BlueDark else Color.LightGray,
                        imageVector = item.icon,
                        contentDescription = "Icon"
                    )
                }
            }

            // Blank
            Box(modifier = Modifier.size(24.dp).background(Color.Unspecified))
            
            // Profile
            AppBottomBarItem.Profile.let { item ->
                IconButton(onClick = { navController.navigate(route = item.route) }) {
                    Icon(
                        tint = if (mainViewModel.recentBottomBarRoute.equals(item.route)) BlueDark else Color.LightGray,
                        imageVector = item.icon,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}

enum class AppBottomBarItem(
    val icon: ImageVector,
    val route: String
) {
    Home(
        icon = Icons.Default.Home,
        route = AppNavRoute.HomeScreen.name
    ),
    Profile(
        icon = Icons.Default.Person,
        route = ""
    )
}