package com.example.uikit.UI


import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


object MatuleColor {

    val Accent = Color(0xff00C07F)
    val AccentInactive = Color(0xff63D4B0)
    val Black = Color(0xff000000)
    val White = Color(0xffffffff)
    val Error = Color(0xffFD3535)
    val Success = Color(0xff00B712)
    val InputBg = Color(0xffF5F5F9)
    var InputStr = Color(0xffEBEBEB)
    var InputIcon = Color(0xffB8C1CC)
    var Placeholder = Color(0xff939396)
    var Description = Color(0xff7E7E9A)
    var CardStr = Color(0xffF4F4F4)

}

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