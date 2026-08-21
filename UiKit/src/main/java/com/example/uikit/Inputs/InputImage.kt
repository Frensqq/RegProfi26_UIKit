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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.createMatuleTypography
import java.io.DataInput

@Composable
fun InputsImage(
    onClick: () -> Unit, painter: Painter? = null, state: Boolean = false
){

    val color = MatuleTheme.colors
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        if(painter == null && !state){
            Row(
                modifier = Modifier.fillMaxWidth()
                    .height(Dimensions.LargeRowHeight)
                    .clip(RoundedCornerShape(Dimensions.MediumRounded))
                    .background(color.surface)
                    .border(Dimensions.SmallBorder, color.inputStroke)
                    .padding(Dimensions.SmallPadding),
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
                .padding(horizontal = Dimensions.ExtraLargePadding)
                .height(Dimensions.ExtraLargeBoxHeight)
                .clip(RoundedCornerShape(Dimensions.MediumRounded))
                .background(color.surface),
                contentAlignment = Alignment.Center
            ) {

                Image(painter = painter?:
                    painterResource(R.drawable.default_product),
                    contentDescription = null,
                    Modifier.fillMaxSize().padding(top = Dimensions.MediumPaddingPlus, start = Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPadding, bottom = Dimensions.MediumPaddingPlus),
                    contentScale = ContentScale.Fit
                    )
            }
        }

    }
}