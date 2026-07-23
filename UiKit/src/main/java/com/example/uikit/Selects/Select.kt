package com.example.uikit.Selects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun Select(text: String, placeholder: String, value: List<String>, onChange:(String) -> Unit, preview: String? = null){
    val color = MatuleTheme.colors
    var state by remember { mutableStateOf(false) }

    Column(){

        if(!preview.isNullOrEmpty()){
            Text(
                preview,
                style = createMatuleTypography().captionRegular,
                color = color.description
                )
            SpacerH(4)
        }

        OutlinedTextField(
            readOnly = true,
            value = text,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    style = createMatuleTypography().headlineRegular,
                    color = MatuleTheme.colors.placeholder
                )
            },
            trailingIcon =  {

                IconButton(
                    onClick = {state = !state},
                ) {
                    Icon(
                        painter = painterResource(R.drawable.chevron_down),
                        contentDescription = null,
                        tint = MatuleTheme.colors.description
                    )
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

        DropdownMenu(
            expanded = state,
            onDismissRequest = {state = !state},
            modifier = Modifier.fillMaxWidth()
        ) {
            value.forEach {it->
                DropdownMenuItem(
                    text = {
                        Text(it)
                           },
                    onClick = {
                        onChange(it)
                        state = false
                    }
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewSelect(){
    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Select(
            value,"Пол",  listOf("Мужской", "Женский", "Другое"),
            { Curr ->
                value = Curr
            }, "test"
        )
    }
}