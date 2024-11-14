package com.example.kzntestproject.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.kzntestproject.R

@Composable
fun SportsListScreen(modifier: Modifier = Modifier){
    val myList = listOf("Canada", "China", "USA", "Pakistan")
    LazyColumn {
        itemsIndexed(myList.toTypedArray()) { _, item ->
            SportItem(
                modifier = modifier.background(colorResource(id = R.color.kzn_white))
            )
        }
    }
}