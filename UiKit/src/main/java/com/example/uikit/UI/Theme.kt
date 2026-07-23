package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MatuleTheme(
    content: @Composable () -> Unit
) {
    val colors = defaultMatuleColors

    val colorScheme = lightColorScheme(
        primary = colors.accent,
        onPrimary = colors.white,
        secondary = colors.accentInactive,
        background = colors.background,
        surface = colors.surface,
        error = colors.error,
        onBackground = colors.onBackground,
        onSurface = colors.onSurface
    )

    CompositionLocalProvider(
        LocalMatuleColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = createMaterialTypography(),
            content = content
        )
    }
}

private fun createMaterialTypography(): Typography {
    val type = MatuleType

    return Typography(
        displayLarge = type.title1Heavy,
        displayMedium = type.title1Semibold,
        displaySmall = type.title2Heavy,
        headlineLarge = type.title2Semibold,
        headlineMedium = type.title2Regular,
        headlineSmall = type.title3Semibold,
        titleLarge = type.title3Medium,
        titleMedium = type.title3Regular,
        titleSmall = type.headlineMedium,
        bodyLarge = type.textMedium,
        bodyMedium = type.textRegular,
        bodySmall = type.captionSemibold,
        labelLarge = type.captionRegular,
        labelMedium = type.caption2Bold,
        labelSmall = type.caption2Regular
    )
}

object MatuleTheme {
    val colors: MatuleColors
        @Composable
        get() = LocalMatuleColors.current

    val typography = createMaterialTypography()
}