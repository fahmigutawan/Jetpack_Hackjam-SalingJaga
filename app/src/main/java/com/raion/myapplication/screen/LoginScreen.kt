package com.raion.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raion.myapplication.R
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.viewmodel.LoginViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(navController: NavController) {
    /**Attrs*/
    val viewModel = getViewModel<LoginViewModel>()

    /**Function*/

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

                // Password
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
            }
        }
    }
}