package com.example.uikit.Header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Bubbles.ButtonExit
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun HeaderSmall(
    Exit:() -> Unit,
    Delete:() -> Unit,
    title: String
){
    Column(modifier = Modifier.fillMaxWidth()) {

        ButtonExit { Exit() }
        SpacerH(24)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title,
                style = createMatuleTypography().title1Heavy,
                color = MatuleTheme.colors.black)

            IconButton(onClick = {Delete()},) {
                Icon(painter = painterResource(R.drawable.delete),
                    contentDescription = null,
                    tint = MatuleTheme.colors.inputIcon)
            }
        }

    }

}