package com.example.uikit.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun Search(text: String, placeholder: String,onChange: (String) -> Unit,onClick:() -> Unit , cansel: () -> Unit){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        val color = MatuleTheme.colors
        OutlinedTextField(

            value = text,
            onValueChange = {onChange(it)},
            modifier = Modifier.fillMaxWidth(Dimensions.SmallfillMaxWidth).height(Dimensions.LargeRowHeight),
            shape = RoundedCornerShape(Dimensions.MediumRounded),
            placeholder = {
                Text(
                    text = placeholder,
                    style = createMatuleTypography().headlineRegular,
                    color = MatuleTheme.colors.placeholder
                )
            },
            leadingIcon = {
                IconButton(
                    onClick = onClick,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        tint = MatuleTheme.colors.description
                    )
                }
            },
            trailingIcon =  {
                if (text != ""){
                    IconButton(
                        onClick = {onChange("")},
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.close),
                            contentDescription = null,
                            tint = MatuleTheme.colors.description
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = color.black,
                focusedBorderColor = color.inputStroke,
                unfocusedBorderColor = color.inputStroke,
                unfocusedTextColor = color.black,
                focusedContainerColor = color.surface,
                unfocusedContainerColor = color.surface,
                cursorColor = color.accent,

                )
        )

        Icon(painterResource(R.drawable.shopping_cart),
            contentDescription = null, tint = MatuleTheme.colors.accent,
            modifier = Modifier.clickable(onClick = {cansel()}).
            padding(horizontal = Dimensions.SmallLargePadding))

    }
}