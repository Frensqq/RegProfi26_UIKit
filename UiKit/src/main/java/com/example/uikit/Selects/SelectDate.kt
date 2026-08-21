package com.example.uikit.Selects

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
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
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDate(text: String, placeholder: String,  onChange:(String) -> Unit, preview: String? = null){
    val color = MatuleTheme.colors
    var state by remember { mutableStateOf(false) }
    val formatted = remember { SimpleDateFormat("yyyy-MM-dd", Locale.US) }

    Column(){

        if(!preview.isNullOrEmpty()){
            Text(
                preview,
                style = createMatuleTypography().captionRegular,
                color = color.description
            )
            SpacerH(Dimensions.ExtraSmallSpacing)
        }

        OutlinedTextField(
            readOnly = true,
            value = text,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth().height(Dimensions.LargeRowHeight),
            shape = RoundedCornerShape(Dimensions.MediumRounded),
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

        if (state) {
            val datePickerState = rememberDatePickerState()
            DatePickerDialog(
                onDismissRequest = { state = false },
                confirmButton = {
                    TextButton({
                        datePickerState.selectedDateMillis?.let {
                            onChange(formatted.format(Date(it)))
                        }
                        state = false
                    }) { Text("OK") }
                },
                dismissButton = {
                    TextButton({
                        state = false
                    }) { Text("Отмена") }
                }
            ) {
                DatePicker(datePickerState)
            }
        }
    }
}

@Preview
@Composable
fun PreviewSelectDate(){
    var value by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        SelectDate(
            value,"Дата",
            { Curr ->
                value = Curr
            }, "Дата"
        )
    }
}