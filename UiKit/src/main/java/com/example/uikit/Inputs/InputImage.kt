package com.example.uikit.Inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography

@Composable
fun InputsImage(
    onClick: () -> Unit, painter: Painter? = null, state: Boolean = false
){

    val color = MatuleTheme.colors
    val typo = MatuleTheme.typography
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        if(painter == null && !state){
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color.surface)
                    .border(1.dp, color.inputStroke)
                    .padding(14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Загрузить",
                    style = createMatuleTypography().headlineRegular,
                    color = color.black
                    )

                Icon(
                    painter = painterResource(R.drawable.plus),
                    contentDescription = null,
                    tint = color.description,
                    modifier = Modifier.clickable{onClick()}
                )
            }

        }

        else{
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 34.dp)
                .height(172.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color.surface),
                contentAlignment = Alignment.Center
            ) {

                Image(painter = painter?:
                    painterResource(R.drawable.default_product),
                    contentDescription = null,
                    Modifier.fillMaxSize().padding(top = 22.dp, start = 5.dp, end = 6.dp, bottom = 18.dp),
                    contentScale = ContentScale.Fit
                    )
            }
        }

    }
}