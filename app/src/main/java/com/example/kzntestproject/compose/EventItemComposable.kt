package com.example.kzntestproject.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kzntestproject.R
import com.example.kzntestproject.SportsDisplayViewModel
import com.example.kzntestproject.data.api.ApiResponse
import com.example.kzntestproject.domain.model.EventDetail
import com.example.kzntestproject.domain.model.SportEvent

@Composable
fun EventItemComposable(eventDetail: List<EventDetail>) {


    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = eventDetail.get(0).timestamp.toString(),
            color = colorResource(id = R.color.kzn_white),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.border(2.dp, color = colorResource(id = R.color.kzn_blue)).padding(3.dp),
            textAlign = TextAlign.Center,
            fontSize = 14.sp)

        Icon(imageVector = Icons.Sharp.Star, contentDescription = "favourite Match", tint = colorResource(
            id = R.color.kzn_white), modifier = Modifier.align(Alignment.CenterHorizontally))

        Text(text = stringResource(id = R.string.competitor_one_default),
            color = colorResource(id = R.color.kzn_white),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )

        Text(text = "vs",
            color = colorResource(id = R.color.kzn_red),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )

        Text(text = stringResource(id = R.string.competitor_two_default),
            color = colorResource(id = R.color.kzn_white),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
    }
}