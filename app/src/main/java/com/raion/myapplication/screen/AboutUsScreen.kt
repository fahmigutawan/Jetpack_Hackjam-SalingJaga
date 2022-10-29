package com.raion.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.raion.myapplication.R

@Composable
fun AboutUsScreen(
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
                .padding(top = 15.dp, start = 25.dp, bottom = 25.dp, end = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                        text = "Tentang Kami",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                }
            }
            Image(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(130.dp),
                painter = painterResource(id = R.drawable.img_aboutus),
                contentDescription = "about us"
            )
            //Main Column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify,
                    text = "SalingJaga merupakan aplikasi yang dibangun untuk memenuhi kebutuhan pengguna dalam situasi gawat darurat. Kami menyediakan layanan keamanan dan keselamatan diri bagi para pengguna dengan cepat dan mudah saat digunakan. Dengan berbagai fitur yang tersedia yaitu fitur utama SOS, fitur pencarian daftar pihak berkewenangan, hingga fitur pendeteksi lokasi pengguna dan lokasi pihak berkewenangan berupa peta."
                )
                Text(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify,
                    text = "SalingJaga juga adalah aplikasi mobile yang diharapkan menjadi pusat pertolongan utama bagi pengguna, khususnya di wilayah kota Malang yang ingin membutuhkan bantuan dalam waktu sesingkat mungkin. Aplikasi kami bekerjasama dengan pemerintah kota malang dan menjamin keamanan dan keselamatan pengguna aplikasi dalam situasi gawat darurat."
                )
            }
            //Contact Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        fontWeight = FontWeight.Bold,
                        color = Color(0, 48, 73),
                        text = "Saling Jaga"
                    )
                    Text(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        textAlign = TextAlign.Justify,
                        color = Color(0, 48, 73),
                        text = "Tentang Kami"
                    )
                    Text(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        textAlign = TextAlign.Justify,
                        color = Color(0, 48, 73),
                        text = "Kebijakan Privasi"
                    )
                    Text(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        textAlign = TextAlign.Justify,
                        color = Color(0, 48, 73),
                        text = "Syarat & Ketentuan"
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        fontWeight = FontWeight.Bold,
                        color = Color(0, 48, 73),
                        text = "Hubungi Kami"
                    )
                    Text(
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        textAlign = TextAlign.Justify,
                        color = Color(0, 48, 73),
                        text = "Senin - Minggu @24 jam"
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier
                                .size(15.dp),
                            painter = painterResource(id = R.drawable.ic_instagram),
                            contentDescription = "Instagram Icon"
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            color = Color(0, 48, 73),
                            text = "@SalingJaga.id"
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            modifier = Modifier
                                .size(15.dp),
                            painter = painterResource(id = R.drawable.ic_gmail),
                            contentDescription = "Gmail Icon"
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            color = Color(0, 48, 73),
                            text = "SalingJaga@gmail.com"
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen(navController = rememberNavController())
}