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
import androidx.compose.ui.platform.LocalConfiguration
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
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.viewmodel.MyProfileViewModel
import com.raion.myapplication.viewmodel.RegisterViewModel
import org.koin.androidx.compose.getViewModel
import kotlin.text.Typography

@Composable
fun MyProfileScreen(
    navController: NavController
) {
    /**Attrs*/
    val viewModel = getViewModel<MyProfileViewModel>()

    /**Content*/
    MyProfileContent(
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
fun MyProfileContent(
    viewModel: MyProfileViewModel,
    navController: NavController
) {
    val btnWidth = LocalConfiguration.current.screenWidthDp / 2

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        //Background
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
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
                .padding(top = 15.dp, start = 25.dp, bottom = 25.dp, end = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                ){
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
                        text = "My Profile",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                }
            }
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
            //Input Field Column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 35.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                //Name Field
                AppTextInputField(
                    placeHolderText = "Full Name",
                    valueState = viewModel.fullNameValueState
                )

                //Email Field
                AppTextInputField(
                    placeHolderText = "Email",
                    valueState = viewModel.emailValueState
                )

                Row {
                    //Province Field
                    AppTextInputField(
                        modifier = Modifier.weight(1f),
                        placeHolderText = "Province",
                        valueState = viewModel.emailValueState
                    )

                    //City Field
                    AppTextInputField(
                        modifier = Modifier.weight(1f),
                        placeHolderText = "City",
                        valueState = viewModel.emailValueState
                    )
                }

                //Phone Number Field
                AppTextInputField(
                    placeHolderText = "No Telpon",
                    valueState = viewModel.phoneNumberValueState
                )

                // Daftar button
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    AppButtonField(
                        modifier = Modifier.width(btnWidth.dp),
                        onClick = {

                        }
                    ) {
                        Text(text = "Save", color = Color.White)
                    }
                }
            }
        }
    }
}