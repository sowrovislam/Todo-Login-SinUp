package com.example.todonot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todonot.uipage.Home
import com.example.todonot.uipage.Login

import com.example.todonot.uipage.Sinup

@Composable
fun NavigationControlUI() {


    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable (Screen.Home.route){

            Home(navController)


        }


        composable (Screen.Login.route){

            Login(navController)


        }

        composable(Screen.sinup.route) {
            Sinup(navController)


        }



    }


}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Login : Screen("login")

    object  sinup: Screen("Sinup")

    object Page : Screen("Page")
}