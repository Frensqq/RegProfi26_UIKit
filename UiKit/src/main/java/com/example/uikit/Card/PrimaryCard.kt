package com.example.uikit.Card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Buttons.ButtonSmall
import com.example.uikit.Tabbar.TabBar
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH
import com.example.uikit.UI.createMatuleTypography

@Composable
fun PrimaryCard(title: String, type: String, cost: String, state: Boolean, onClick:()->Unit){
    var localState by remember { mutableStateOf(state) }
    CardBackground(
        content = {
            Column(modifier = Modifier.fillMaxWidth().height(136.dp).padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(title, maxLines = 2, style = createMatuleTypography().headlineMedium , color = MatuleTheme.colors.black)
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(type,
                            maxLines = 1,
                            style = createMatuleTypography().captionSemibold,
                            color = MatuleTheme.colors.placeholder
                            )
                        SpacerH(4)
                        Text("$cost ₽", maxLines = 1, style = createMatuleTypography().title3Semibold, color = MatuleTheme.colors.black)
                    }
                    ButtonSmall(text = if (localState) "Добавить" else "Убрать",
                        {
                            localState = !localState
                            onClick()
                        }
                        ,state = localState)
                }

            }
        }
    )
}

@Preview
@Composable
fun CardPreview(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        PrimaryCard("Рубашка Воскресенье для машинного вязания", "Мужская одежда", "300", true, {})
    }
}