package com.example.uikit.Controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DropShadowScope
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme

@Composable
fun Toggle(state: Boolean, onClick: (Boolean) -> Unit){
    val color = MatuleTheme.colors
    Row(
        modifier = Modifier
            .width(Dimensions.SmallBoxWidth)
            .height(Dimensions.SmallBoxHeight)
            .clip(CircleShape)
            .background(if (state) color.accent else color.inputStroke)
            .padding(Dimensions.SmallCardPadding),
        horizontalArrangement = if (!state) Arrangement.Start else Arrangement.End

    ) {
        Box(
           modifier = Modifier
               .size(24.dp)
               .clip(CircleShape)
               .background(color.white)
               .clickable{onClick(!state)}
        )
    }


}