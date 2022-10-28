package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raion.myapplication.R
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.snackbarListener
import com.raion.myapplication.viewmodel.LoginViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(navController: NavController) {
    /**Attrs*/
    val viewModel = getViewModel<LoginViewModel>()

    /**Function*/
    snackbarListener("Terjadi error saat login. Coba lagi nanti", viewModel.showErrorSnackbar)
    snackbarListener("Masukkan semua data yang dibutuhkan", viewModel.showFillAllFieldsSnackbar)
    if(viewModel.startLoginFlow.value){
        LaunchedEffect(key1 = true){
            viewModel.loginWithEmailPassword(
                onSuccess = {
                    navController.navigate(route = AppNavRoute.HomeScreen.name){
                        popUpTo(route = AppNavRoute.LoginScreen.name){
                            inclusive = true
                        }
                    }
                },
                onFailed = {
                    viewModel.showErrorSnackbar.value = true
                }
            )
        }
    }

    /**Content*/
    LoginContent(
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
private fun LoginContent(
    viewModel: LoginViewModel,
    navController: NavController
) {
    val btnWidth = LocalConfiguration.current.screenWidthDp / 2

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        //BG
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = R.drawable.ic_landing_background,
            contentDescription = "landing BG",
            contentScale = ContentScale.Crop
        )

        //All Fields
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Text
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Masuk", style = MaterialTheme.typography.h5)
                    Text(text = "Lorem ipsum bla bla", style = MaterialTheme.typography.subtitle2)
                }

                // Email Field
                AppTextInputField(placeHolderText = "Email", valueState = viewModel.emailValueState)

                // Password & Lupa
                Column {
                    AppTextInputField(
                        placeHolderText = "Password",
                        valueState = viewModel.passwordValueState,
                        visualTransformation = if (viewModel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                        endContent = {
                            Icon(
                                modifier = Modifier.clickable {
                                    viewModel.passwordVisible.value = !viewModel.passwordVisible.value
                                },
                                imageVector = if (viewModel.passwordVisible.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = "Password Visible"
                            )
                        }
                    )
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                        Text(
                            modifier = Modifier.clickable { /*TODO*/ },
                            text = "Lupa Password ?",
                            color = Color.Blue
                        )
                    }
                }

                // Masuk button
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    AppButtonField(
                        modifier = Modifier.width(btnWidth.dp),
                        onClick = {
                            if(viewModel.allFilled()){
                                viewModel.startLoginFlow.value = true
                            }else{
                                viewModel.showFillAllFieldsSnackbar.value = true
                            }
                        }
                    ) {
                        Text(text = "Masuk", color = Color.White)
                    }
                }

                // Register text button
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Belum punya akun?")
                        Text(
                            modifier = Modifier.clickable { /*TODO*/ },
                            text = "Daftar",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(text = "atau")
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.LightGray,
                            thickness = 1.dp
                        )
                        Box(
                            modifier = Modifier.background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(modifier = Modifier.padding(8.dp), text = "masuk melalui")
                        }
                    }
                }

                // Login methods buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Google
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { /*TODO*/ },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = Color.White
                    ) {
                        Icon(imageVector = Icons.Default.Circle, contentDescription = "Icon")
                    }

                    // Facebook
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { /*TODO*/ },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = Color.White
                    ) {
                        Icon(imageVector = Icons.Default.Circle, contentDescription = "Icon")
                    }

                    // Apple
                    AppButtonField(
                        shape = RoundedCornerShape(8.dp),
                        onClick = { /*TODO*/ },
                        borderColor = Color.LightGray,
                        borderWidth = 1.dp,
                        backgroundColor = Color.White
                    ) {
                        Icon(imageVector = Icons.Default.Circle, contentDescription = "Icon")
                    }
                }
            }
        }
    }
}