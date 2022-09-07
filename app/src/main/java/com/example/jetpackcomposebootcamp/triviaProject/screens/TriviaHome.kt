package com.example.jetpackcomposebootcamp.triviaProject.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposebootcamp.triviaProject.components.Questions


@Composable
fun TriviaHome(viewModel: QuestionViewModel = hiltViewModel()) =  Questions(viewModel = viewModel)

