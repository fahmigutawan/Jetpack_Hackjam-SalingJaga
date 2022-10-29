package com.raion.myapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raion.myapplication.R

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    ),
    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    ),
    h5 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    ),
    h6 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_black))
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    ),
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular))
    ),
    button = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_medium))
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_tint))
    ),
    overline = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_tint))
    )
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)