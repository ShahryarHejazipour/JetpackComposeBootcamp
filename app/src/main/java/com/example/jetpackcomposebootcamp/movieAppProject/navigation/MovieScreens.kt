package com.example.jetpackcomposebootcamp.movieAppProject.navigation

enum class MovieScreens {

    HomeScreen,
    DetailsScreen,
    TestScreen;

    companion object{

        fun fromRoute(route:String?) : MovieScreens =
            when(route?.substringBefore("/")) {

                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                TestScreen.name -> TestScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}