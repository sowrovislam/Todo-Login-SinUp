package com.example.todonot.uipage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.todonot.navigation.Screen
import com.example.todonot.viewmodel.AuthViewModel
@Composable
fun MainWork(navController: NavHostController) {

    val viewModel: AuthViewModel = viewModel()
    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState == "Legged Out") {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.MainWork.route) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Button(
            onClick = {
                viewModel.LogOut()
            }
        ) {
            Text("Logout")
        }
    }

}