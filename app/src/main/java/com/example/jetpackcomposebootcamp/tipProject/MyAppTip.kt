package com.example.jetpackcomposebootcamp.tipProject

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.jetpackcomposebootcamp.ui.theme.JetPackComposeBootcampTheme

@Composable
fun MyAppTip(content: @Composable () -> Unit) {

    JetPackComposeBootcampTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}