package com.example.jetpackcomposebootcamp.stateIntroProject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//@Preview
@Composable
fun CreateCircle(moneyCounter:Int,updateMoneyCounter:(Int)->Unit) {


    /*
    in this Composable, we remove inner State to outside of this composable, by State Hoisting
     */

    /*var moneyCounter by rememberSaveable {
        mutableStateOf(0)
    }*/

    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {

            updateMoneyCounter(moneyCounter + 1)

        },
        shape = CircleShape,
        backgroundColor = Color.White, elevation = 10.dp) {

        Box(contentAlignment = Alignment.Center) {

            Text(text = "Tap", style = TextStyle(fontSize = 20.sp))

        }


    }


}
