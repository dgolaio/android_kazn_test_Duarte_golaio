package com.example.kzntestproject.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.kzntestproject.R
import com.example.kzntestproject.SportsDisplayViewModel
import com.example.kzntestproject.data.api.ApiResponse

@Composable
fun SportsListScreen(modifier: Modifier = Modifier, viewModel: SportsDisplayViewModel){
    val sportsEvents by viewModel.sportEvents.collectAsState()

    when(sportsEvents) {
        is ApiResponse.EventList -> {
            val events = (sportsEvents as ApiResponse.EventList).e
        LazyColumn {
            items(events.size) { event ->
                SportItem(
                    sportEvents = events.get(event).events,
                    id = events.get(event).sportCode ?:"0",
                    sportsDisplayViewModel = viewModel,
                    modifier = Modifier.background(colorResource(id = R.color.kzn_white),
                ))
            }
        }
    }

        is ApiResponse.SportCategory -> {}
    }
}