package com.raion.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.raion.myapplication.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.raion.myapplication.component.AppButtonField
import com.raion.myapplication.component.AppTextInputField
import com.raion.myapplication.navigation.AppNavRoute
import com.raion.myapplication.ui.theme.BlueDark
import com.raion.myapplication.viewmodel.SosFormViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SosFormScreen(navController: NavController) {
    /**Attrs*/
    val viewModel = getViewModel<SosFormViewModel>()

    /**Function*/

    /**Content*/
    SosFormContent(
        viewModel = viewModel,
        navController = navController
    )
}

@Composable
private fun SosFormContent(
    viewModel: SosFormViewModel,
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                text = "SOS",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
            )

            FormContainer(
                viewModel = viewModel
            )

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                AppButtonField(
                    backgroundColor = BlueDark,
                    rippleColor = Color.White,
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Kirim Data", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun FormContainer(
    viewModel: SosFormViewModel
) {
    //Column
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
            .padding(bottom = 5.dp, end = 2.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(vertical = 45.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // Nama Pelapor Field
        AppTextInputField(placeHolderText = "Nama Pelapor", valueState = viewModel.pelaporValueState)

        // Pesan Kejadian Field
        AppTextInputField(placeHolderText = "Pesan Kejadian(*)", valueState = viewModel.pesanValueState)

        // Pihak yang Dirugikan Field
        AppTextInputField(placeHolderText = "Pihak yang dirugikan(*)", valueState = viewModel.pihakRugiValueState)

        // Tanggal Field
        AppTextInputField(placeHolderText = "Tanggal", valueState = viewModel.tanggalValueState)

        // Waktu Field
        AppTextInputField(placeHolderText = "Waktu", valueState = viewModel.waktuValueState)

        // Keterangan Field
        AppTextInputField(placeHolderText = "Keterangan", valueState = viewModel.keteranganValueState)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Foto/video",
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    color = Color(121, 126, 126)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(75.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = "Tambah Foto/Video",
                        tint = Color(102, 155, 188)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Rekaman",
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    color = Color(121, 126, 126)
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(75.dp),
                        imageVector = Icons.Default.Add,
                        contentDescription = "Tambah Foto/Video",
                        tint = Color(102, 155, 188)
                    )
                }
            }
        }
    }
}