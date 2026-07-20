package com.example.uikit.Buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Bubbles.ButtonExit
import com.example.uikit.Bubbles.ButtonMessage
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.MatuleTypography
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun ButtonBig(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean
){
    val color = MatuleTheme.colors
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.height(56.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonColors(
            containerColor = color.accent,
            contentColor = color.white,
            disabledContainerColor = color.accentInactive,
            disabledContentColor = color.white
        ),
    ) {
        Text(
            text,
            style = createMatuleTypography().title3Semibold,
            textAlign = TextAlign.Center,
        )
    }

}


@Preview
@Composable
fun testButtons(){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        ButtonBig("test", {}, true)
        SpacerH(5)
        ButtonBig("tset2", {}, false)
        SpacerH(5)
        ButtonSmall("tset2", {}, true)
        SpacerH(5)
        ButtonSmall("tset2", {}, false)
        SpacerH(5)
        ButtonChips("Популярное", {}, true)
        SpacerH(5)
        ButtonChips("Мужское", {}, false)
        SpacerH(5)
        ButtonCart("Популярное", 200,{}, true)
        SpacerH(5)
        ButtonMedium("Популярное", {}, true, true)
        SpacerH(5)
        ButtonMedium("Популярное", {}, false, true)
        SpacerH(5)
        ButtonMedium("Популярное", {}, true, false)
        SpacerH(5)
        ButtonMedium("Популярное", {}, false, false)
        SpacerH(5)
        ButtonExit({})
        SpacerH(5)
        ButtonMessage({})
    }

}