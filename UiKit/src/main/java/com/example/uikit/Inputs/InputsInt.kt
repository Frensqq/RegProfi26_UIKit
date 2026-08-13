package com.example.uikit.Inputs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun InputInt(
    value: String,
    placeholder: String = "1",
    onChangeValue: (String) -> Unit,
    focusRequester: FocusRequester,
    index: Int,
    focuses: List<FocusRequester>
) {
    val color = MatuleTheme.colors
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 1) {
                val oldValue = value
                onChangeValue(newValue)
                // Вперед при вводе
                if (newValue.isNotEmpty() && oldValue.isEmpty() && index < focuses.size - 1) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focuses[index + 1].requestFocus()
                    }
                }
                // Назад при удалении
                else if (newValue.isEmpty() && index > 0) {
                    CoroutineScope(Dispatchers.Main).launch {
                        focuses[index - 1].requestFocus()
                    }
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color.accent,
            unfocusedBorderColor = color.inputIcon,
            focusedContainerColor = color.surface,
            unfocusedContainerColor = color.surface,
            errorContainerColor = color.error.copy(alpha = 0.1f),
            cursorColor = color.accent ,
            focusedTextColor = color.black,
            unfocusedTextColor = color.black,
            errorPlaceholderColor = Color(0xff939396),
            focusedPlaceholderColor = Color(0xff939396),
            unfocusedPlaceholderColor = Color(0xff939396),
            errorBorderColor = color.accent
        ),

        placeholder ={Text(placeholder, style = createMatuleTypography().textRegular.copy(textAlign = TextAlign.Center))},
        modifier = Modifier
            .size(48.dp)
            .focusRequester(focusRequester) ,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp),
        textStyle = createMatuleTypography().textRegular.copy(textAlign = TextAlign.Center),
    )
}

@Preview
@Composable
fun PreviewInputInt() {
    val count = 4
    val values = remember { mutableStateListOf(*Array(count) { "" }) }
    val focuses = remember { List(count) { FocusRequester() } }

    Row {
        repeat(count) { index ->
            InputInt(
                value = values[index],
                onChangeValue = { values[index] = it },
                focusRequester = focuses[index],
                index = index,
                focuses = focuses
            )
        }
    }
}