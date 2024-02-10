package com.example.composeactivity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    navController : NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = "home_screen"){
        composable(route = "home_screen"){
            HomeScreen(onNavigateToSecondScreen = {navController.navigate("second_screen")})
        }

        composable(route = "second_screen"){
            SecondScreen()
        }
    }

}