package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import com.raion.myapplication.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.BlueDark

@Composable
fun SosScreen(navController: NavController) {
    /**Attrs*/

    /**Function*/

    /**Content*/
    SosContent(
        navController = navController
    )
}

@Composable
private fun SosContent(
    navController: NavController
) {
    val btnSize = LocalConfiguration.current.screenWidthDp / 3
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                    .background(
                        BlueDark
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = "SOS", style = MaterialTheme.typography.h4, color = Color.White)

                    Text(
                        text = "Tekan Tombol Panik Button Apabila Terjadi Keadaan Darurat",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }

        // Icon
        item {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                AsyncImage(
                    modifier = Modifier.size(84.dp),
                    model = R.drawable.ic_sos,
                    contentDescription = "SOS"
                )
            }
        }

        // Sos Button
        item {

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .size((btnSize + 100).dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = 0.1f))
                )

                Box(
                    modifier = Modifier
                        .size((btnSize + 75).dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = 0.3f))
                )

                Box(
                    modifier = Modifier
                        .size((btnSize + 50).dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = 0.5f))
                )

                Box(
                    modifier = Modifier
                        .size((btnSize + 25).dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = 0.7f))
                )

                Box(
                    modifier = Modifier
                        .size((btnSize).dp)
                        .clip(CircleShape)
                        .clickable {navController.navigate(AppNavRoute.SosFormScreen.name)}
                        .background(Color.Red.copy(alpha = 1f)),
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "SOS", color = Color.White, style = MaterialTheme.typography.h4)
                }
            }
        }
    }
}