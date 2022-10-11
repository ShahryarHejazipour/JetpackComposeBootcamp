package com.example.jetpackcomposebootcamp.readerAppProject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposebootcamp.movieAppProject.screens.details.DetailsScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.details.BookDetailsScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.home.Home
import com.example.jetpackcomposebootcamp.readerAppProject.screens.login.ReaderLoginScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.search.SearchScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.splash.ReaderSplashScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.states.ReaderStateScreen
import com.example.jetpackcomposebootcamp.readerAppProject.screens.update.BookUpdateScreen


@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name){
        composable(ReaderScreens.SplashScreen.name){
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name){
            Home(navController = navController)
        }


        composable(ReaderScreens.LoginScreen.name){
            ReaderLoginScreen()

        }
        composable(ReaderScreens.CreateAccountScreen.name){

        }
        composable(ReaderScreens.SearchScreen.name){
            SearchScreen()

        }
        composable(ReaderScreens.DetailScreen.name){
            BookDetailsScreen()

        }
        composable(ReaderScreens.UpdateScreen.name){
            BookUpdateScreen()
        }
        composable(ReaderScreens.ReaderStateScreen.name){
            ReaderStateScreen()
        }
    }
}