package com.example.navegacionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacionapp.views.DetailView
import com.example.navegacionapp.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeView(navController)
        }
        composable("detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("opcional") { type = NavType.StringType; defaultValue = "opcional" }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
    }
}