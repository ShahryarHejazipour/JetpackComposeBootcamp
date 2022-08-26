package com.example.jetpackcomposebootcamp.triviaProject.network

import com.example.jetpackcomposebootcamp.triviaProject.model.Question
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestions():Question
}