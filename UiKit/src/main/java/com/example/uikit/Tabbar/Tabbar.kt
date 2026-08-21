package com.example.uikit.Tabbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimensions
import com.example.uikit.UI.MatuleTheme
import com.example.uikit.UI.SpacerH

@Composable
fun TabBar(home: ()-> Unit, catalog: () -> Unit, orders: () -> Unit, profile: () -> Unit, current: String){

    var currentState by remember { mutableStateOf(current) }
    Column(
        Modifier.fillMaxWidth().height(Dimensions.BottomBarSpacing)
    ) {
        Box(Modifier.fillMaxWidth().height(Dimensions.SmallBorder).background(MatuleTheme.colors.placeholder))

        SpacerH(Dimensions.SmallSpacing)

        Row(
            Modifier.fillMaxWidth().padding(start = Dimensions.ExtraSmallPadding, end = Dimensions.ExtraSmallPaddingPlus),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TabBarItem({
                home()
                currentState = it
            }, painterResource(R.drawable.home),
                text = "Главная",
                state = "Главная" == currentState
                )
            TabBarItem({
                catalog()
                currentState = it
            }, painterResource(R.drawable.catalog),
                text = "Каталог",
                state = "Каталог" == currentState
                )
            TabBarItem({
                orders()
                currentState = it
            }, painterResource(R.drawable.orders),
                text = "Заказы",
                state = "Заказы" == currentState
                )
            TabBarItem({
                profile()
                currentState = it
            }, painterResource(R.drawable.profile),
                text = "Профиль",
                state = "Профиль" == currentState
                )



        }
    }
}

@Preview
@Composable
fun TabBarPreview(){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        TabBar({},{},{},{},"Заказы")
    }
}