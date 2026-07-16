package com.example.uikit.UI

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R

data class Type(
    val Title1Semibold: TextStyle = TextStyle(),
    val Title1Heavy: TextStyle = TextStyle(),
    val Title2Regular: TextStyle = TextStyle(),
    val Title2Semibold: TextStyle = TextStyle(),
    val Title2Heavy: TextStyle = TextStyle(),
    val Title3Regular: TextStyle = TextStyle(),
    val Title3Medium: TextStyle = TextStyle(),
    val Title3Semibold: TextStyle = TextStyle(),
    val HeadlineRegular: TextStyle = TextStyle(),
    val HeadlineMedium: TextStyle = TextStyle(),
    val TextRegular: TextStyle = TextStyle(),
    val TextMedium: TextStyle = TextStyle(),
    val CaptionRegular: TextStyle = TextStyle(),
    val CaptionSemibold:TextStyle = TextStyle(),
    val Caption2Regular: TextStyle = TextStyle(),
    val Caption2Bold:TextStyle = TextStyle()

)

fun Typography():Type{

    fun textStyle(
        fontFamily: Int,
        fontSize:Int,
        lineHeight:Int,
        letterSpacing: Double = 0.00

    ) = TextStyle(
        fontFamily = FontFamily(Font(fontFamily)),
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp
    )

    return Type(
        Title1Semibold = textStyle(R.font.semibold, 24, 28 , 0.33),
        Title1Heavy = textStyle(R.font.heavy, 24, 28 , 0.33),
        Title2Regular = textStyle(R.font.regular, 20, 28 , 0.38),
        Title2Semibold = textStyle(R.font.semibold, 20, 28 , 0.38),
        Title2Heavy = textStyle(R.font.heavy, 20, 28 , 0.38),
        Title3Regular = textStyle(R.font.regular, 17, 24 ),
        Title3Medium = textStyle(R.font.medium, 17, 24 ),
        Title3Semibold = textStyle(R.font.semibold, 17, 24 ),
        HeadlineMedium = textStyle(R.font.medium,16,20,-0.32),
        HeadlineRegular = textStyle(R.font.regular,16,20,-0.32),
        TextRegular = textStyle(R.font.regular,15,20),
        TextMedium = textStyle(R.font.medium,15,20),
        CaptionRegular = textStyle(R.font.regular, 14, 20 ),
        CaptionSemibold = textStyle(R.font.semibold, 14, 20 ),
        Caption2Regular = textStyle(R.font.regular, 12, 20 ),
        Caption2Bold = textStyle(R.font.bold, 12, 20 ),

    )
}

val MatuleType = Typography()