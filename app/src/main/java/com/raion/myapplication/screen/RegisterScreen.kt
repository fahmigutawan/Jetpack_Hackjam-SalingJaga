package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.raion.myapplication.R
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.snackbarListener
import com.raion.myapplication.viewmodel.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterScreen(navController: NavController) {
    /**Attrs*/
    val viewModel = getViewModel<RegisterViewModel>()

    /**Function*/
    snackbarListener("Masukkan semua data yang dibutuhkan", viewModel.showShouldFillAllFields)
    snackbarListener("Gagal registrasi. Coba lagi nanti", viewModel.showErrorSnackbar)
    if(viewModel.startRegisterFlow.value){
        viewModel.registerWithEmailPassword(
            onSuccess = {
                navController.navigate(route = AppNavRoute.HomeScreen.name)
            },
            onFailed = {
                viewModel.showErrorSnackbar.value = !viewModel.showErrorSnackbar.value
            }
        )
    }

    /**Content*/
    RegisterContent(
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
private fun RegisterContent(
    viewModel: RegisterViewModel,
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
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .height(5.dp)
                        .width(40.dp),
                    backgroundColor = Color(180, 180, 180)
                ) {}
                // Text
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Daftar", style = MaterialTheme.typography.h5)
                    Text(text = "Lorem ipsum bla bla", style = MaterialTheme.typography.subtitle2)
                }

                //Name Field
                AppTextInputField(
                    placeHolderText = "Nama Lengkap",
                    valueState = viewModel.fullNameValueState
                )

                //Email Field
                AppTextInputField(
                    placeHolderText = "Alamat Email",
                    valueState = viewModel.emailValueState
                )

                //Phone Number Field
                AppTextInputField(
                    placeHolderText = "No Telpon",
                    valueState = viewModel.phoneNumberValueState
                )

                //Address
                AppTextInputField(
                    placeHolderText = "Alamat Rumah",
                    valueState = viewModel.addressValueState
                )

                // Password
                AppTextInputField(
                    placeHolderText = "Kata Sandi",
                    valueState = viewModel.passwordValueState,
                    visualTransformation = if (viewModel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    endContent = {
                        Icon(
                            modifier = Modifier.clickable {
                                viewModel.passwordVisible.value = !viewModel.passwordVisible.value
                            },
                            imageVector = if (viewModel.passwordVisible.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = "Password Visible",
                            tint = Color.Gray
                        )
                    }
                )

                // Daftar button
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    AppButtonField(
                        modifier = Modifier.width(btnWidth.dp),
                        onClick = {
                            if(viewModel.allFilled()){
                                viewModel.startRegisterFlow.value = true
                            }else{
                                viewModel.showShouldFillAllFields.value = true
                            }
                        }
                    ) {
                        Text(text = "Masuk", color = Color.White)
                    }
                }

                // Masuk text button
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Sudah punya akun?")
                        Text(
                            modifier = Modifier.clickable { navController.navigate(route = AppNavRoute.LoginScreen.name) },
                            text = "Masuk",
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
                            Text(modifier = Modifier.padding(vertical = 8.dp), text = "masuk melalui")
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