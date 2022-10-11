package com.example.jetpackcomposebootcamp.readerAppProject.screens.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Preview
@Composable
fun ReaderSplashScreen(navController: NavController = NavController(context = LocalContext.current)) {
    
    Surface(modifier = androidx.compose.ui.Modifier
        .padding(15.dp)
        .size(330.dp),
        shape = CircleShape,
        border= BorderStroke(width = 2.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier.padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "A . Reader",
                style = MaterialTheme.typography.h3,
                color = Color.Red.copy(alpha = 0.5f)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(15.dp))
            Text(text = "\"Read. Change . Yourself\"", style = MaterialTheme.typography.h5, color = Color.LightGray)

        }

    }

}