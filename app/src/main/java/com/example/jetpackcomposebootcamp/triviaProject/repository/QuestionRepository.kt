package com.example.jetpackcomposebootcamp.triviaProject.repository

import com.example.jetpackcomposebootcamp.triviaProject.data.DataOrException
import com.example.jetpackcomposebootcamp.triviaProject.model.QuestionItem
import com.example.jetpackcomposebootcamp.triviaProject.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {

    //Using Wrapper class for adding metadata into the response --- ArrayList<QuestionItem>() ---
    private val listOfQuestions = DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

}