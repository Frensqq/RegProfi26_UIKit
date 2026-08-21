package com.example.uikit.Card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography
import java.nio.file.WatchEvent

@Composable
fun ListOrderItem(data: OrderCardItem){
    Row(
        modifier = Modifier.fillMaxWidth().height(Dimensions.RowHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(
            data.title,
            modifier = Modifier.fillMaxWidth(Dimensions.SmallfillMaxWidth),
            style = createMatuleTypography().captionRegular,
            color = MatuleTheme.colors.black,
            maxLines = 2
        )
        Text(
            "${data.count}x${data.cost} ₽",
            style = createMatuleTypography().captionRegular,
            color = MatuleTheme.colors.black
        )
    }
}