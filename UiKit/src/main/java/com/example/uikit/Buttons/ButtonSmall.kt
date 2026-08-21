package com.example.uikit.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun ButtonSmall(text: String,
                onClick: () -> Unit,
                state: Boolean = true,
                enabled: Boolean = true

){
    val color = MatuleTheme.colors
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.height(Dimensions.SmallButtonHeight)
            .width(Dimensions.SmallButtonWidth),
        shape = RoundedCornerShape(Dimensions.MediumRounded),
        colors = if (state) {ButtonColors(
            containerColor = color.accent,
            contentColor = color.white,
            disabledContainerColor = color.accentInactive,
            disabledContentColor = color.white
        )}
        else{
            ButtonColors(
                containerColor = color.white,
                contentColor = color.accent,
                disabledContainerColor = color.white,
                disabledContentColor = color.accentInactive
            )
        },
        border = BorderStroke(width = Dimensions.SmallBorder, color =  color.accent),
        contentPadding = PaddingValues(Dimensions.SmallBorder)
    ) {
        Text(
            text,
            style = createMatuleTypography().captionSemibold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }

}