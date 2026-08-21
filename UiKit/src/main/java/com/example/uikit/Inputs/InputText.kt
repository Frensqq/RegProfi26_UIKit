package com.example.uikit.Inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.Selects.SelectDate
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun Inputs(
    value: String,
    placeholder: String,
    OnChange: (String) -> Unit,
    title: String? = null,
    isPass: Boolean = false,
    isError: String? = null
){

    Column() {
        if(!title.isNullOrEmpty()){
            Text(
                text=title,
                style = createMatuleTypography().captionRegular,
                color = MatuleTheme.colors.description
            )
            SpacerH(Dimensions.SmallSpacing)
        }

        val color = MatuleTheme.colors
        var statePass by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = value,
            isError = !isError.isNullOrEmpty(),
            onValueChange = { OnChange(it) },
            placeholder = {
                Text(
                    placeholder,
                    style = createMatuleTypography().textRegular,
                    color = Color(0xff939396)
                )
            },
            modifier = Modifier.height(Dimensions.LargeRowHeight).fillMaxWidth(),
            shape = RoundedCornerShape(Dimensions.MediumRounded),
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
            textStyle = createMatuleTypography().textRegular,
            visualTransformation =
                if (isPass && !statePass) PasswordVisualTransformation()
            else VisualTransformation.None ,
            trailingIcon = {
                if(isPass) {
                    IconButton(
                        onClick = {
                            statePass = !statePass
                        }
                    ) {
                        Icon(
                            painter = if (!statePass) painterResource(
                                R.drawable.eyeopen
                            ) else painterResource(R.drawable.eyeclose),
                            contentDescription = null
                        )
                    }
                }
            }
        )

        if(!isError.isNullOrEmpty()){
            SpacerH(Dimensions.SmallSpacing)
            Text(
                text=isError,
                style = createMatuleTypography().captionRegular,
                color = MatuleTheme.colors.error
            )
        }
    }

}


@Preview
@Composable
fun PreviewSelectDate(){
    var value by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,) {

        Inputs("test", " ", {},)
        SpacerH(Dimensions.MediumSpacing)
        Inputs("", "test", {},"tset")
        SpacerH(Dimensions.MediumSpacing)

        Inputs("", "test", {},null, true )
        SpacerH(Dimensions.MediumSpacing)

        Inputs("test", "test", {},null, true )
        SpacerH(Dimensions.MediumSpacing)

        Inputs("", "test", {},null, true, "Bad error" )
        SpacerH(Dimensions.MediumSpacing)

        Inputs("test", "test", {},null, true,"Bad error" )
        SpacerH(Dimensions.MediumSpacing)

        InputsImage({})
        InputsImage({}, state = true)

    }
}