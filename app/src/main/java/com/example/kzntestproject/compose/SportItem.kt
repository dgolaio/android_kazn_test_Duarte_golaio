package com.example.kzntestproject.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kzntestproject.R

@Composable
fun SportItem(modifier: Modifier = Modifier) {
     var expanded by remember { mutableStateOf(false) }

     val icons = if(expanded)
          Icons.Filled.KeyboardArrowUp
     else
          Icons.Filled.KeyboardArrowDown

     Box(modifier = modifier
          .border(BorderStroke(1.dp, Color.Black))
          .padding(10.dp)) {
          Row(modifier = Modifier.fillMaxWidth(1f)) {

               Image(
                    modifier = Modifier
                         .fillMaxWidth(0.2f)
                         .aspectRatio(5 / 3f)
                         .clipToBounds(),
                    painter = painterResource(id = R.drawable.badmintonball),
                    contentDescription = "SportImage"
               )

               Text(text = stringResource(id = R.string.sport_default), modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.CenterVertically),
                    textAlign = TextAlign.Start, fontWeight = FontWeight.Bold)

                   SwitchFavouritesComposable(modifier.align(Alignment.CenterVertically))

                    Spacer(modifier = Modifier.width(20.dp))

                    Icon(icons, contentDescription = "icon",
                         modifier
                              .clickable {
                                   expanded = !expanded
                              }
                              .align(Alignment.CenterVertically),
                    )
          }
     }
     if(expanded) {
          ExpandedSportItem(modifier = modifier)
     }

     Spacer(modifier = Modifier.height(20.dp))
}