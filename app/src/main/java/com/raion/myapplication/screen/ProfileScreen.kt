package com.raion.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.raion.myapplication.R
import com.raion.myapplication.navigation.AppNavRoute
import kotlin.text.Typography

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        //Background
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.23f),
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
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 35.dp),
                text = "Profile",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
            )
            Box(
                modifier = Modifier
                    .size(120.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                //Profile Picture Container
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(60.dp))
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 4.dp,
                                color = Color(102, 155, 188),
                                shape = RoundedCornerShape(60.dp)
                            )
                            .padding(6.dp)
                            .clip(shape = RoundedCornerShape(58.dp)),
                        painter = painterResource(id = R.drawable.damkar),
                        contentDescription = "Profile Picture"
                    )
                }
                //Edit Profile Picture
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp),
                            imageVector = Icons.Filled.DriveFileRenameOutline,
                            contentDescription = "Edit",
                            tint = Color(0, 48, 73)
                        )
                    }
                }
            }
            Text(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp),
                text = "Nama",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color(19, 15, 38)
            )
            Text(
                text = "test@mail.com",
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = Color.Gray
            )
            //Column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 35.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                //My Profile Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(25.dp),
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "My Profile Icon",
                        tint = Color(19, 15, 38),
                    )
                    Text(
                        text = "My Profile",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = Color(19, 15, 38)
                    )
                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Go to My Profile",
                                tint = Color(19, 15, 38)
                            )
                        }
                    }
                }
                //Settings Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(25.dp),
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings Icon",
                        tint = Color(19, 15, 38),
                    )
                    Text(
                        text = "Settings",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = Color(19, 15, 38)
                    )
                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = {navController.navigate(route = AppNavRoute.SettingsScreen.name)}) {
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Go to Settings",
                                tint = Color(19, 15, 38),
                            )
                        }
                    }
                }//FAQ Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(25.dp),
                        imageVector = Icons.Filled.Help,
                        contentDescription = "FAQ Icon",
                        tint = Color(19, 15, 38),
                    )
                    Text(
                        text = "FAQ",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = Color(19, 15, 38)
                    )
                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Go to FAQ",
                                tint = Color(19, 15, 38),
                            )
                        }
                    }
                }//About App Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(25.dp),
                        imageVector = Icons.Filled.Error,
                        contentDescription = "About App Icon",
                        tint = Color(19, 15, 38),
                    )
                    Text(
                        text = "About App",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        color = Color(19, 15, 38)
                    )
                    Row(
                        modifier = Modifier
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = "Go to About App",
                                tint = Color(19, 15, 38),
                            )
                        }
                    }
                }
            }
            //Settings Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(25.dp),
                    imageVector = Icons.Default.Logout,
                    contentDescription = "Logout Icon",
                    tint = Color(19, 15, 38),
                )
                Text(
                    text = "Logout",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    color = Color(19, 15, 38)
                )
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Logout",
                            tint = Color(19, 15, 38),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}