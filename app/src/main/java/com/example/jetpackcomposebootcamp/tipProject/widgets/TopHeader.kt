package com.example.jetpackcomposebootcamp.tipProject.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun TopHeader(totalPerPerson:Double = 134.0) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(all = 15.dp)
        .height(150.dp)
        .clip(
            shape = CircleShape.copy(all = CornerSize(12.dp))
        ), color = Color(color = 0xFFE9D7F7 )
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
    ) {
        Column(modifier = Modifier.padding(12.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.h5
            )
            Text(text = "$$total", style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold)
        }
    }

}
