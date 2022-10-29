package com.raion.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.raion.myapplication.ui.theme.BlueDark

@Composable
fun AppTopBar(
    onBackClicked: () -> Unit,
    endContent: (@Composable () -> Unit)? = null,
    backgroundColor: Color = BlueDark,
    title: String,
    titleColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
) {
    TopAppBar(
        modifier = Modifier.clip(shape),
        backgroundColor = backgroundColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = titleColor
                    )
                }

                endContent?.let { it() }
            }

            Text(text = title, color = titleColor)
        }
    }
}

@Composable
fun AppTopBarNoContent(
    backgroundColor: Color = BlueDark,
    title: String,
    titleColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
) {
    TopAppBar(
        modifier = Modifier.clip(shape),
        backgroundColor = backgroundColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, color = titleColor)
        }
    }
}
