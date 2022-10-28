package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.viewmodel.RegisterViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterScreen(navController: NavController) {
    /**Attrs*/
    val viewModel = getViewModel<RegisterViewModel>()

    /**Function*/

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
                ){}
                // Text
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Daftar", style = MaterialTheme.typography.h5)
                    Text(text = "Lorem ipsum bla bla", style = MaterialTheme.typography.subtitle2)
                }

                //Name Field
                AppTextInputField(placeHolderText = "Nama Lengkap", valueState = viewModel.fullNameValueState)

                //Email Field
                AppTextInputField(placeHolderText = "Alamat Email", valueState = viewModel.emailValueState)

                //Phone Number Field
                AppTextInputField(placeHolderText = "No Telpon", valueState = viewModel.phoneNumberValueState)

                //Address
                AppTextInputField(placeHolderText = "Alamat Rumah", valueState = viewModel.addressValueState)

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
            }
        }
    }
}