package com.example.jetpackcomposebootcamp.triviaProject.repository

import android.util.Log
import com.example.jetpackcomposebootcamp.triviaProject.data.DataOrException
import com.example.jetpackcomposebootcamp.triviaProject.model.QuestionItem
import com.example.jetpackcomposebootcamp.triviaProject.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {

    //Using Wrapper class for adding metadata into the response --- ArrayList<QuestionItem>() ---
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{

        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception:Exception){
            dataOrException.e = exception
            Log.d("Exception", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")

        }

        return dataOrException

    }

}