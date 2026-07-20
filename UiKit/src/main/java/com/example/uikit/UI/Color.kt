package com.example.uikit.UI


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.staticCompositionLocalOf




data class MatuleColors(
    val accent: Color,
    val accentInactive: Color,
    val background: Color,
    val surface: Color,
    val onBackground: Color,
    val onSurface: Color,
    val error: Color,
    val success: Color,
    val inputStroke: Color,
    val inputIcon: Color,
    val placeholder: Color,
    val description: Color,
    val cardStroke: Color,
    val white: Color,
    val black: Color
)

val defaultMatuleColors = MatuleColors(
    accent = Color(0xff00C07F),
    accentInactive = Color(0xff63D4B0),
    background = Color(0xffffffff),
    surface = Color(0xffF5F5F9),
    onBackground = Color(0xff000000),
    onSurface = Color(0xff000000),
    error = Color(0xffFD3535),
    success = Color(0xff00B712),
    inputStroke = Color(0xffEBEBEB),
    inputIcon = Color(0xffB8C1CC),
    placeholder = Color(0xff939396),
    description = Color(0xff7E7E9A),
    cardStroke = Color(0xffF4F4F4),
    white = Color(0xffffffff),
    black = Color(0xff000000)
)

val LocalMatuleColors = staticCompositionLocalOf { defaultMatuleColors }

object MatuleGradient{

    var lineGreen = Brush.verticalGradient(
        colors = listOf(
            Color(0xff75D8BC),
            Color(0xff5BADCB)
        )
    )

    var lineBlue= Brush.verticalGradient(
        colors = listOf(
            Color(0xffB4D5FF),
            Color(0xff60A6FD)
        )
    )

}