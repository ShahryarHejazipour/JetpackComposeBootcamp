package com.example.jetpackcomposebootcamp.readerAppProject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebootcamp.readerAppProject.navigation.ReaderNavigation

@Composable
fun ReaderApp(){


    Surface(color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally) {
            ReaderNavigation()

        }



    }

}