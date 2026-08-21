package com.example.uikit.Buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerW
import com.example.uikit.UI.createMatuleTypography

@Composable
fun ButtonCart(
    text: String,
    cost: Int,
    onClick: () -> Unit,
    enabled: Boolean
){
    val color = MatuleTheme.colors
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.height(Dimensions.ButtonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimensions.MediumRounded),
        colors = ButtonColors(
            containerColor = color.accent,
            contentColor = color.white,
            disabledContainerColor = color.accentInactive,
            disabledContentColor = color.white
        ),
        contentPadding = PaddingValues(Dimensions.MediumPadding)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {

                Icon(
                    painter = painterResource(R.drawable.shopping_cart),
                    contentDescription = null,
                    tint = color.white
                    )
                SpacerW(Dimensions.MediumSpacing)
                Text(
                    text,
                    style = createMatuleTypography().title3Semibold,
                    textAlign = TextAlign.Center,
                )
            }

            Text(
                cost.toString() + " ₽",
                style = createMatuleTypography().title3Semibold,
                textAlign = TextAlign.Center,
            )
        }

    }

}