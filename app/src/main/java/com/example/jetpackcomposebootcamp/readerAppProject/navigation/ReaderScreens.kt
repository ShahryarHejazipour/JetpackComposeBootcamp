package com.example.jetpackcomposebootcamp.readerAppProject.navigation

import com.example.jetpackcomposebootcamp.movieAppProject.screens.home.HomeScreen

enum class ReaderScreens {

    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderHomeScreen,
    ReaderStateScreen;

    companion object{

        fun fromRoute(route:String?) : ReaderScreens
        = when(route?.substringBefore(delimiter = "/")){

            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            SearchScreen.name -> SearchScreen
            DetailScreen.name -> DetailScreen
            UpdateScreen.name -> UpdateScreen
            ReaderStateScreen.name ->  ReaderStateScreen
            null -> ReaderHomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized!")

            }


    }

}