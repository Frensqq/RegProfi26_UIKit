package com.example.uikit.Inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.MatuleTheme

@Composable
fun InputsImage(
    onClick: () -> Unit, painter: Painter?, state: Boolean
){

    val color = MatuleTheme.colors
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp)
            .height(172.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color.surface)
    ) {
        
    }
}