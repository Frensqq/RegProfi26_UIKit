package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun MatuleTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = lightColorScheme(
        primary = MatuleColor.Accent,
        onPrimary = MatuleColor.White,
        secondary = MatuleColor.AccentInactive,
        background = MatuleColor.White,
        surface = MatuleColor.InputBg,
        error = MatuleColor.Error,
        onBackground = MatuleColor.Black,
        onSurface = MatuleColor.Black
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = createMaterialTypography(),
        content = content
    )
}

private fun createMaterialTypography(): Typography {
    val type = MatuleType

    return Typography(
        //Крупные заголовки
        displayLarge = type.title1Heavy,
        displayMedium = type.title1Semibold,
        displaySmall = type.title2Heavy,


        // Заголовки
        headlineLarge = type.title2Semibold,
        headlineMedium = type.title2Regular,
        headlineSmall = type.title3Semibold,

        // Маленькие Заголовки
        titleLarge = type.title3Medium,
        titleMedium = type.title3Regular,
        titleSmall = type.headlineMedium,

        // Основной текст
        bodyLarge = type.textMedium,
        bodyMedium = type.textRegular,
        bodySmall = type.captionSemibold,

        // Подписи
        labelLarge = type.captionRegular,
        labelMedium = type.caption2Bold,
        labelSmall = type.caption2Regular
    )
}