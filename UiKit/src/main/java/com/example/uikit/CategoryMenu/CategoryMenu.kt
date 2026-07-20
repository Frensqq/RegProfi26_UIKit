package com.example.uikit.CategoryMenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Buttons.ButtonChips
import com.example.uikit.UI.SpacerW

@Composable
fun CategoryMenu(category: List<String>,currentCategory: String, onClick: (String) -> Unit ){

    LazyRow(
        modifier = Modifier.fillMaxWidth().height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { SpacerW(4) }
        items(category){
            ButtonChips(it, {onClick(it)}, it == currentCategory)
        }
        item { SpacerW(4) }
    }
}

@Preview
@Composable
fun TestCategoryMenu(){

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        var listString = listOf("Мужское","Женское","Детям","Акссесуары")
        var category by remember { mutableStateOf(listString[0]) }

        CategoryMenu(listString, category, {category=it})
    }

}