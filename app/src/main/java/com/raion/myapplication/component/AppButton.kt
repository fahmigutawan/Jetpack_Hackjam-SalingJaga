package com.raion.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.raion.myapplication.ui.theme.BlueNormal

@Composable
fun AppButtonField(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = BlueNormal,
    disabledBackgroudnColor: Color = Color.Gray,
    rippleColor: Color = Color.Black,
    enabled: Boolean = true,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Unspecified,
    shape: Shape = RoundedCornerShape(Int.MAX_VALUE.dp),
    content: @Composable () -> Unit
) {
    val contentHeight = remember { mutableStateOf(0.dp) }
    val contentWidth = remember { mutableStateOf(0.dp) }
    val localDensity = LocalDensity.current

    Box(contentAlignment = Alignment.Center) {
        Box(
            modifier = modifier
                .clip(shape)
                .size(width = contentWidth.value, height = contentHeight.value)
                .border(width = borderWidth, color = borderColor, shape = shape)
                .background(if (enabled) backgroundColor else disabledBackgroudnColor)
        )

        Box(
            modifier = Modifier
                .onSizeChanged {
                    contentWidth.value = with(localDensity) { it.width.toDp() }
                    contentHeight.value = with(localDensity) { it.height.toDp() }
                }
                .padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)
        ) {
            content()
        }

        Box(
            modifier = modifier
                .clip(shape)
                .size(width = contentWidth.value, height = contentHeight.value)
                .clickable(
                    enabled = enabled,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = rippleColor),
                    onClick = onClick
                )
        )
    }
}