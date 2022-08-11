package com.example.jetpackcomposebootcamp.movieAppProject

import androidx.compose.runtime.Composable

@Composable
fun MyAppMovie(content : @Composable () -> Unit) {
    content()
}