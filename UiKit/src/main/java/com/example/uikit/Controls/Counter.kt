package com.example.uikit.Controls

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun Counter(count:Int, onClick:(Int) -> Unit){
    var color = MatuleTheme.colors
    Row(
        Modifier
            .width(64.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color.surface)
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            painter = painterResource(R.drawable.minus),
            modifier = Modifier.clickable{if (count > 1) {onClick(count-1)} },
            contentDescription = null,
            tint = if (count > 1)  color.description else color.inputIcon
        )

        Box(Modifier
            .width(1.dp)
            .height(16.dp)
            .background(color.inputStroke)
        )

        Icon(
            painter = painterResource(R.drawable.plus),
            modifier = Modifier.clickable{ onClick(count+1)},
            contentDescription = null,
            tint = color.description
        )

    }

}