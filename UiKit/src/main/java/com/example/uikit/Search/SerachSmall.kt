package com.example.uikit.Search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun SearchSmall(text: String, placeholder: String,onChange: (String) -> Unit,onClick:() -> Unit ){
    val color = MatuleTheme.colors
    OutlinedTextField(

        value = text,
        onValueChange = {onChange(it)},
        modifier = Modifier.width(265.dp).height(48.dp),
        shape = RoundedCornerShape(10.dp),
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
}