package com.example.jetpackcomposebootcamp.stateIntroProject

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun MyApp() {

    val moneyCounter = rememberSaveable{

        mutableStateOf(0)

    }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.secondary
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "$${moneyCounter.value}", style = TextStyle(color = Color.White,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter=moneyCounter.value){ newValue ->
                moneyCounter.value = newValue

            }

            if (moneyCounter.value > 25){
                Text(text = "Lots of money!!")
            }
        }
    }

}