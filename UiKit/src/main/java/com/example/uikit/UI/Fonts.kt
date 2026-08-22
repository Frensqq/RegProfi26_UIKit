package com.example.uikit.UI

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.uikit.R


data class MatuleTypography(
    val title1: TextStyle,
    val title1Semibold: TextStyle,
    val title1Heavy: TextStyle,
    val title2Regular: TextStyle,
    val title2Semibold: TextStyle,
    val title2Heavy: TextStyle,
    val title3Regular: TextStyle,
    val title3Medium: TextStyle,
    val title3Semibold: TextStyle,
    val headlineRegular: TextStyle,
    val headlineMedium: TextStyle,
    val textRegular: TextStyle,
    val textMedium: TextStyle,
    val captionRegular: TextStyle,
    val captionSemibold: TextStyle,
    val caption2Regular: TextStyle,
    val caption2Bold: TextStyle
)

fun createMatuleTypography(): MatuleTypography {
    fun textStyle(
        fontRes: Int,
        fontSize: Int,
        lineHeight: Int,
        letterSpacing: Float = 0f
    ) = TextStyle(
        fontFamily = FontFamily(Font(fontRes)),
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = letterSpacing.sp
    )

    return MatuleTypography(
        title1Semibold = textStyle(R.font.semibold, 24, 28, 0.33f),
        title1 = textStyle(R.font.heavy, 40, 42, 0.33f),
        title1Heavy = textStyle(R.font.heavy, 24, 28, 0.33f),
        title2Regular = textStyle(R.font.regular, 20, 28, 0.38f),
        title2Semibold = textStyle(R.font.semibold, 20, 28, 0.38f),
        title2Heavy = textStyle(R.font.heavy, 20, 28, 0.38f),
        title3Regular = textStyle(R.font.regular, 17, 24),
        title3Medium = textStyle(R.font.medium, 17, 24),
        title3Semibold = textStyle(R.font.semibold, 17, 24),
        headlineRegular = textStyle(R.font.regular, 16, 20, -0.32f),
        headlineMedium = textStyle(R.font.medium, 16, 20, -0.32f),
        textRegular = textStyle(R.font.regular, 15, 20),
        textMedium = textStyle(R.font.medium, 15, 20),
        captionRegular = textStyle(R.font.regular, 14, 20),
        captionSemibold = textStyle(R.font.semibold, 14, 20),
        caption2Regular = textStyle(R.font.regular, 12, 20),
        caption2Bold = textStyle(R.font.bold, 12, 20)
    )
}

val MatuleType = createMatuleTypography()