package com.raion.myapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.raion.myapplication.R

@Composable
fun PihakScreen(
    navController: NavHostController,
    title: String,
    image: Int,
    buka: String,
    alamat: String,
    dinas: String
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
                .fillMaxHeight(0.17f),
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
            //ROW PIHAK
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
                        text = title,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                    )
                }
            }
            //DUMMY SEARCH BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(35.dp)
                    .clip(RoundedCornerShape(13.dp))
                    .background(Color(235, 243, 246)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = Color(179, 180, 180)
                    )
                }
                Text(
                    text = "Search",
                    color = Color(179, 180, 180)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                itemsIndexed(
                    listOf("a", "b", "c", "d", "e", "f", "g", "h", "i")
                ) { index, item ->
                    Spacer(modifier = Modifier.height(10.dp))
                    Container(
                        image = image,
                        buka = buka,
                        alamat = alamat,
                        dinas = dinas
                    )
                }
            }
        }
    }
}

@Composable
fun Container(
    image: Int,
    buka: String,
    alamat: String,
    dinas: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxHeight()
                .weight(6f)
                .background(Color(235, 243, 246))
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = image),
                    contentDescription = dinas,
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 3.dp),
                    text = "Kota Malang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier.padding(bottom = 3.dp),
                    text = dinas,
                    fontSize = 12.sp
                )
                Text(
                    modifier = Modifier.padding(bottom = 3.dp),
                    text = "Buka        : $buka",
                    fontSize = 12.sp
                )
                Text(
                    text = "Alamat     : $alamat",
                    fontSize = 12.sp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(235, 243, 246)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        modifier = Modifier
                            .size(20.dp),
                        painter = painterResource(id = R.drawable.ic_whatsapp),
                        contentDescription = "WhatsApp"
                    )
                }
            }
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(235, 243, 246)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier
                            .size(20.dp),
                        imageVector = Icons.Default.Language,
                        contentDescription = "Web"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PihakScreenPreview() {
    PihakScreen(
        navController = rememberNavController(),
        title = "Damkar",
        image = R.drawable.img_damkar,
        buka = "07.00-23.00",
        alamat = "Jl. Bingkil No.1",
        dinas = "Dinas Pemadam Kebakaran"
    )
}

@Preview
@Composable
fun ContainerPreview() {
    Container(
        image = R.drawable.img_damkar,
        buka = "07.00-23.00",
        alamat = "Jl. Bingkil No.1",
        dinas = "Dinas Pemadam Kebakaran"
    )
}