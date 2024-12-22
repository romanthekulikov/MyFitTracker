package com.roman_kulikov.myfittracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roman_kulikov.myfittracker.screens.AuthScreen

@Composable
fun Navigator() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Auth) {
        composable<Auth> { AuthScreen() }
    }
}