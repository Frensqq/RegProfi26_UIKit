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
                modifier = Modifier.height(137.dp).padding(16.dp),
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
                            modifier = Modifier.padding(top = 2.dp),
                            style = createMatuleTypography().headlineRegular,
                            color = MatuleTheme.colors.black
                        )
                    }

                    SpacerH(8)

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            date,
                            maxLines = 1,
                            style = createMatuleTypography().captionRegular,
                            color = MatuleTheme.colors.placeholder
                        )
                        SpacerW(6)
                        Box(
                            modifier = Modifier.size(5.dp).clip(CircleShape)
                                .background(MatuleTheme.colors.placeholder)
                        )
                        SpacerW(6)
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
                    SpacerW(8)
                    Text(
                        "Посмотреть",
                        style = createMatuleTypography().headlineRegular,
                        color = MatuleTheme.colors.placeholder
                    )
                }


            }
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(MatuleTheme.colors.placeholder))

            Column(Modifier.fillMaxWidth().padding(16.dp).height(277.dp))
            {
                Text(
                    "Описание",
                    style = createMatuleTypography().headlineMedium,
                    color = MatuleTheme.colors.placeholder
                )
                SpacerH(16)

                LazyColumn(modifier = Modifier.height(88.dp)) {
                    items(listOrder){
                        ListOrderItem(it)
                    }
                }

                SpacerH(22)

                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(MatuleTheme.colors.placeholder))
                SpacerH(22)

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    ButtonChips("Чек покупки", {checkClick()}, false, width = 144)

                    ButtonChips("Помощь", {help()}, false, width = 144)
                }
                SpacerH(16)
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