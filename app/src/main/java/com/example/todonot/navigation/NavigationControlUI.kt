package com.example.todonot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todonot.uipage.Home
import com.example.todonot.uipage.Login


import com.example.todonot.uipage.MainWork

import com.example.todonot.uipage.Sinup
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationControlUI() {


    val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()


    NavHost(
        navController = navController,
        startDestination = if (auth.currentUser != null) "MainWork" else "Home"

    ) {
        composable (Screen.Home.route){

            Home(navController)


        }


        composable (Screen.Login.route){

            Login(navController)


        }

        composable(Screen.Sinup.route) {
            Sinup(navController)


        }

        composable(Screen.MainWork.route) {
            MainWork(navController)


        }



    }


}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")

    object  Sinup: Screen("Sinup")

    object MainWork : Screen("MainWork")
}