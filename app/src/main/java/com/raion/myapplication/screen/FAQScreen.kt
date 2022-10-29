package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.raion.myapplication.navigation.AppNavRoute

@Composable
fun FAQScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        //Bakcground
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.17f),
            shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0, 48, 73))
            )
        }
        //Column
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp, start = 25.dp, bottom = 25.dp, end = 25.dp)
        ) {
            //ROW Title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    modifier = Modifier
                        .size(24.dp),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ChevronLeft,
                        contentDescription = "chevron left",
                        tint = Color.White
                    )
                }
                Row(
                    modifier = Modifier
                        .weight(1f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "FAQ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                }
            }
            //Column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 110.dp),
                verticalArrangement = Arrangement.spacedBy(13.dp)
            ) {
                FAQContent()
                FAQContent()
                FAQContent()
            }
        }
    }
}

@Composable
fun FAQContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color(207, 232, 241))
                .padding(vertical = 10.dp, horizontal = 30.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Mattis a sapien velit posuere.",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color(235, 243, 246))
                .padding(vertical = 10.dp, horizontal = 30.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque sollicitudin enim cras purus malesuada id tellus. Feugiat vitae velit pulvinar libero vel pellentesque eget.",
                fontSize = MaterialTheme.typography.body1.fontSize
            )
        }
    }
}

@Preview
@Composable
fun FAQScreenPreview() {
    FAQScreen(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun FAQContenPreview() {
    FAQContent()
}