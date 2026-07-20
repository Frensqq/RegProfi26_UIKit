package com.example.uikit.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun ButtonMedium(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean,
    state: Boolean
){
    val color = MatuleTheme.colors
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.height(48.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = if (state) ButtonColors(
            containerColor = color.accent,
            contentColor = color.white,
            disabledContainerColor = color.surface,
            disabledContentColor = color.description
        )
        else {
            ButtonColors(
                containerColor = color.white,
                contentColor = color.accent,
                disabledContainerColor = color.surface,
                disabledContentColor = color.description
            )
             },
        border = if(!state && enabled) BorderStroke(1.dp, color.accent) else null
    ) {
        Text(
            text,
            style = createMatuleTypography().title3Semibold,
            textAlign = TextAlign.Center,
        )
    }

}