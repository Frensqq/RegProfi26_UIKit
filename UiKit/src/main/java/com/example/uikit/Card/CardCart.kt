package com.example.uikit.Card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Buttons.ButtonSmall
import com.example.uikit.Controls.Counter
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW
import com.example.uikit.UI.createMatuleTypography


@Composable
fun CardCart(
    title: String,
    count: String,
    cost: String,
    changeCount:(Int) -> Unit,
    onDelete: () -> Unit,
) {
    CardBackground(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimensions.ProductCardHeight)
                    .padding(Dimensions.MediumPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = title,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth(Dimensions.fillMaxWidth),
                        style = createMatuleTypography().headlineMedium,
                        color = MatuleTheme.colors.black
                    )

                    Icon(painter = painterResource(R.drawable.close),
                        modifier = Modifier.clickable{
                            onDelete()
                        },
                        contentDescription = null,
                        tint = MatuleTheme.colors.description
                        )

                }

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom) {
                    Text(
                        "$cost ₽",
                        style = createMatuleTypography().title3Medium,
                        modifier = Modifier.padding(bottom = Dimensions.SmallCardPadding),
                        color = MatuleTheme.colors.black)

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            "$count шт",
                            style = createMatuleTypography().textMedium,
                            modifier = Modifier.padding(bottom = Dimensions.CardPadding),
                            color = MatuleTheme.colors.black)

                        SpacerW(Dimensions.BigSpacing)

                        Counter(count.toInt()) {
                            changeCount(it)
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun CardCartPreview(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CardCart("Рубашка Воскресенье для машинного вязания", "1", "300", {it }, {})
    }
}