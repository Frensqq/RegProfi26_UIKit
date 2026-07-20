package com.example.uikit.Bubbles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme

@Composable
fun ButtonMessage(onClick: () -> Unit){
    val color = MatuleTheme.colors
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable{onClick()}
            .clip(RoundedCornerShape(8.dp))
            .background(color.surface)
        , contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.message),
            contentDescription = null,
            tint = color.description
        )
    }
}