package com.example.jetpackcomposebootcamp.triviaProject.di

import com.example.jetpackcomposebootcamp.triviaProject.network.QuestionAPI
import com.example.jetpackcomposebootcamp.triviaProject.repository.QuestionRepository
import com.example.jetpackcomposebootcamp.triviaProject.util.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)



    @Singleton
    @Provides
    fun provideQuestionAPI(): QuestionAPI {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
            GsonConverterFactory.create())
            .build()
            .create(QuestionAPI::class.java)

    }
}