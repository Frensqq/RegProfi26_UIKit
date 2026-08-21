package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Buttons.ButtonChips
import com.example.uikit.Buttons.ButtonMedium
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.SpacerW
import com.example.uikit.UI.createMatuleTypography

data class OrderCardItem(
    val title: String,
    val count: Int,
    val cost: Int
)

@Composable
fun OrderCardOpen(number: String, cost: String, date: String, state: String, onClick:()->Unit, listOrder: List<OrderCardItem>, help:()->Unit, checkClick: ()->Unit, exit:()->Unit){


    CardBackground {
        Column() {
            Column(
                modifier = Modifier.height(Dimensions.ProductCardHeight).padding(Dimensions.MediumPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Column() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            "Заказ № $number",
                            maxLines = 1,
                            style = createMatuleTypography().title3Semibold,
                            color = MatuleTheme.colors.black
                        )
                        Text(
                            "$cost ₽",
                            maxLines = 1,
                            modifier = Modifier.padding(Dimensions.ExtraSmallCardPadding),
                            style = createMatuleTypography().headlineRegular,
                            color = MatuleTheme.colors.black
                        )
                    }

                    SpacerH(Dimensions.SmallSpacing)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            date,
                            maxLines = 1,
                            style = createMatuleTypography().captionRegular,
                            color = MatuleTheme.colors.placeholder
                        )
                        SpacerW(Dimensions.CardPadding)
                        Box(
                            modifier = Modifier.size(Dimensions.SmallBoxSize).clip(CircleShape)
                                .background(MatuleTheme.colors.placeholder)
                        )
                        SpacerW(Dimensions.CardPadding)
                        Text(
                            state,
                            maxLines = 1,
                            style = createMatuleTypography().captionRegular,
                            color = if (state == "Оплачен") MatuleTheme.colors.accent else MatuleTheme.colors.description
                        )

                    }
                }


                Row(Modifier.clickable {
                    onClick()
                }) {
                    Icon(
                        painter = painterResource(R.drawable.icon_file_text),
                        contentDescription = null,
                        tint = MatuleTheme.colors.placeholder
                    )
                    SpacerW(Dimensions.SmallSpacing)
                    Text(
                        "Посмотреть",
                        style = createMatuleTypography().headlineRegular,
                        color = MatuleTheme.colors.placeholder
                    )
                }


            }
            Box(modifier = Modifier.fillMaxWidth().height(Dimensions.SmallBorder).background(MatuleTheme.colors.placeholder))

            Column(Modifier.fillMaxWidth().padding(Dimensions.MediumPadding).height(Dimensions.ColumnHeight))
            {
                Text(
                    "Описание",
                    style = createMatuleTypography().headlineMedium,
                    color = MatuleTheme.colors.placeholder
                )
                SpacerH(Dimensions.MediumSpacing)

                LazyColumn(modifier = Modifier.height(Dimensions.BottomBarSpacing)) {
                    items(listOrder){
                        ListOrderItem(it)
                    }
                }

                SpacerH(Dimensions.ExtraMediumSpacing)

                Box(modifier = Modifier.fillMaxWidth().height(Dimensions.SmallBorder).background(MatuleTheme.colors.placeholder))
                SpacerH(Dimensions.ExtraMediumSpacing)

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    ButtonChips("Чек покупки", {checkClick()}, false, width = Dimensions.ChipsWidth)

                    ButtonChips("Помощь", {help()}, false, width = Dimensions.ChipsWidth)
                }
                SpacerH(Dimensions.MediumPadding)
                ButtonMedium("Закрыть",{exit()}, true, false)

            }
        }
    }
}

@Preview
@Composable
fun OrderCardOpenPreview(){
val list = listOf<OrderCardItem>(
    OrderCardItem("test", 1,200),
    OrderCardItem("test2", 4,500),
    OrderCardItem("test3", 3,100),

)

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        OrderCardOpen("1231313", "2342", "2023-12-06 12:00", "Оплачен", {},list , {}, {}, {})
    }
}