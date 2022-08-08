package com.example.jetpackcomposebootcamp.movieAppProject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposebootcamp.movieAppProject.screens.details.DetailsScreen
import com.example.jetpackcomposebootcamp.movieAppProject.screens.home.HomeScreen


// Setting up the navigation stage by stage -> See the NavigationComponentChart.png

@Composable
fun MovieNavigation() {

    /*
    first stage : definition the navController state
     */
    val navController = rememberNavController()

    /*
    second stage : definition the NavHost
     */

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

        /*
        third stage : definition the NavGraph by using composable() function -> in this lambda we have the NavGraphBuilder
         */

        // Home Composable Or Home destination
        composable(MovieScreens.HomeScreen.name){
            // Here we pass where this should lead us by using a Composable Function -> It Means a New Destination
            
            HomeScreen(navController = navController)
            
        }

        // Details Composable Or Details destination
        composable(MovieScreens.DetailsScreen.name+"/{movie}",

            //This is for passing data between destinations
        arguments = listOf(navArgument("movie"){type = NavType.StringType})){ backStackEntry ->

            //this is for getting arrived data
           DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
            
        }




    }

}