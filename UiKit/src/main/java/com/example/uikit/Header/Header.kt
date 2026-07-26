package com.example.uikit.Header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Bubbles.ButtonExit
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography
import java.nio.file.WatchEvent

@Composable
fun Header(
    Exit:() -> Unit,
    Delete:() -> Unit,
    title: String
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 26.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top

    ) {
        ButtonExit { Exit() }

        Text(title,
            style = createMatuleTypography().title2Semibold,
            color = MatuleTheme.colors.black,
            modifier = Modifier.padding(top = 2.dp)
        )

        IconButton(onClick = {Delete()}, modifier = Modifier.padding(top = 6.dp)) {
            Icon(painter = painterResource(R.drawable.delete),
                contentDescription = null,
                tint = MatuleTheme.colors.inputIcon)
        }
    }
}