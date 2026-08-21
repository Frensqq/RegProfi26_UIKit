package com.example.uikit.Tabbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun TabBarItem(OnClick: (String) -> Unit, icon: Painter, text: String, state: Boolean){

    Column(
        modifier = Modifier.height(Dimensions.LargeBoxHeight).width(Dimensions.LargeBoxWidth).padding(bottom = Dimensions.SmallBorder)
            .clickable{OnClick(text)},
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(painter = icon,
            contentDescription = null,
            tint = if (state) MatuleTheme.colors.accent else MatuleTheme.colors.inputIcon)

        Text(text,
            style = createMatuleTypography().caption2Regular,
            color = if (state) MatuleTheme.colors.accent else MatuleTheme.colors.inputIcon

        )
    }


}