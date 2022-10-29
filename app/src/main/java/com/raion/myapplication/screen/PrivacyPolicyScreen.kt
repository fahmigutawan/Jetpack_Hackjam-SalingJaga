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
fun PrivacyPolicyScreen(
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
                        text = "Kebijakan Privasi",
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
                painter = painterResource(id = R.drawable.img_privacypolicy),
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
                    text = "Kerahasiaan Informasi Pribadi adalah hal yang penting bagi SalingJaga (Kami). Kami berkomitmen untuk melindungi dan menghormati privasi pengguna (Anda) saat mengakses dan menggunakan fitur, teknologi, konten, dan produk yang Kami sediakan di aplikasi dan situs web Kami (selanjutnya, secara bersama-sama disebut sebagai Platform)."
                )
                Text(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify,
                    text = "Kebijakan Privasi ini mengatur landasan dasar mengenai bagaimana Kami menggunakan informasi pribadi yang Kami terima dari Anda (Informasi Pribadi). Kebijakan Privasi ini berlaku bagi seluruh pengguna Platform, kecuali diatur dalam Kebijakan Privasi yang terpisah."
                )
                Text(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Justify,
                    text = "Jika Anda memiliki pertanyaan mengenai Kebijakan Privasi ini atau Anda ingin mendapatkan akses dan/atau melakukan koreksi terhadap Informasi Pribadi Anda, silahkan dapat menghubungi Kami melalui"
                )
            }
            //Contact Column
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
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
fun PrivacyPolicyScreenPreview() {
    PrivacyPolicyScreen(navController = rememberNavController())
}