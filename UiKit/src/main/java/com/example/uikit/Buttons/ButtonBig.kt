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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Bubbles.ButtonExit
import com.example.uikit.Bubbles.ButtonMessage
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.UI.Dimensions
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
        modifier = Modifier.height(Dimensions.ButtonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimensions.MediumRounded),
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
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonBig("tset2", {}, false)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonSmall("tset2", {}, true)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonSmall("tset2", {}, false)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonChips("Популярное", {}, true)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonChips("Мужское", {}, false)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonCart("Популярное", 200,{}, true)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonMedium("Популярное", {}, true, true)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonMedium("Популярное", {}, false, true)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonMedium("Популярное", {}, true, false)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonMedium("Популярное", {}, false, false)
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonExit({})
        SpacerH(Dimensions.ExtraSmallSpacing)
        ButtonMessage({})
        var stateToggle by remember { mutableStateOf(false) }
        SpacerH(Dimensions.ExtraSmallSpacing)
        Toggle(stateToggle,{stateToggle = it})
        var buttonControl by remember { mutableStateOf(1) }
        SpacerH(Dimensions.ExtraSmallSpacing)
        Counter(buttonControl) {buttonControl=it }
    }

}