package com.example.kzntestproject.compose


import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SwitchFavouritesComposable(modifier: Modifier){
    var isEnable by remember{ mutableStateOf(false)}
    Switch(checked = isEnable,
        onCheckedChange = {
            isEnable = it
        },
        modifier = modifier)
}