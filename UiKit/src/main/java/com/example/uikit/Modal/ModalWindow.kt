package com.example.uikit.Modal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Buttons.ButtonBig
import com.example.uikit.R
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun ModalWindow(
    title: String,
    description: String,
    text: String,
    cost: Int,
    onClickButton: () -> Unit,
    state: Boolean,
    closeWin: ()->Unit,
){

    Box(Modifier.fillMaxSize()
        .clickable(onClick = {closeWin()})
        .background(MatuleTheme.colors.black.copy(alpha = 0.6f))
,        contentAlignment = Alignment.BottomCenter) {

        Column(Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)).background(
            MatuleTheme.colors.white).padding(horizontal = 20.dp)
        ) {


            SpacerH(24)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = title,
                    maxLines = 2,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    style = createMatuleTypography().title2Semibold,
                    color = MatuleTheme.colors.black
                )


                Box(Modifier.size(24.dp).clip(CircleShape)
                    .background(MatuleTheme.colors.inputIcon),
                    contentAlignment = Alignment.Center) {

                    Icon(painter = painterResource(R.drawable.close),
                        modifier = Modifier.clickable{
                            closeWin()
                        },
                        contentDescription = null,
                        tint = MatuleTheme.colors.description
                    )
                }

            }

            SpacerH(20)

            Text("Описание",
                style = createMatuleTypography().headlineMedium,
                color = MatuleTheme.colors.placeholder)

            SpacerH(8)

            Text(description,
                style = createMatuleTypography().textRegular,
                color = MatuleTheme.colors.black
            )

            SpacerH( 50)
            SpacerH(13)

            Text("Примерный расход",
                style = createMatuleTypography().captionRegular,
                color = MatuleTheme.colors.placeholder
                )
            SpacerH(4)

            Text(text,
                style = createMatuleTypography().headlineMedium,
                color = MatuleTheme.colors.placeholder
            )

            SpacerH(19)

            ButtonBig("Добавить за $cost ₽", {
                onClickButton()
            },state
                )

            SpacerH(20)


        }

    }

}

@Preview
@Composable
fun PreviewModal(){
    ModalWindow("test Product",
            "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку.\n" +
            "Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько.\n" +
            "Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г.\n" +
            "Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие.\n" +
            "Примерный расход на шапку с подгибом 70-90г.", "70-90г", 690, {},true,) { }
}