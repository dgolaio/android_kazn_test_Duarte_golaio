package com.example.kzntestproject.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.kzntestproject.R
import com.example.kzntestproject.SportsDisplayViewModel
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun BaseScreen(modifier: Modifier = Modifier, viewModel: SportsDisplayViewModel = hiltViewModel()) {
    val sportsEvents by viewModel.sportEvents.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadSportsEvents()
    }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(top = 40.dp, start = 2.dp, end = 2.dp)
        .background(colorResource(id = R.color.kzn_gray))
        ) {

        Box(modifier = modifier
            .background(colorResource(id = R.color.kzn_blue))
            .align(Alignment.CenterHorizontally)){
            Text(text = stringResource(id = R.string.app_name),
                fontSize = 24.sp,
                modifier = modifier
                    .fillMaxWidth(1f)
                    .border(1.dp, colorResource(id = R.color.kzn_gray))
                    .padding(30.dp),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.kzn_white),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        SportsListScreen(modifier = modifier, viewModel = viewModel)
    }
}