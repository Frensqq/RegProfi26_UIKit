package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.MatuleTheme

@Composable
fun CardBackground(content: Composable){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(138.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MatuleTheme.colors.white)
            .dropShadow(shape = RoundedCornerShape(12.dp), shadow = Shadow(1.dp))
    ) {
        content
    }

}