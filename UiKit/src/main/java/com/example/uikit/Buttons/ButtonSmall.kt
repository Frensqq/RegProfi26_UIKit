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
        modifier = Modifier.height(40.dp)
            .width(96.dp),
        shape = RoundedCornerShape(10.dp),
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
        border = BorderStroke(width = 1.dp, color =  color.accent),
        contentPadding = PaddingValues(10.dp)
    ) {
        Text(
            text,
            style = createMatuleTypography().captionSemibold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }

}