package com.example.todonot.uipage

import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todonot.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.time.delay

@Composable
fun Home(navController: NavHostController){

    LaunchedEffect(Unit) {
        delay(2000)  // 2000 ms = 2 seconds
        navController.navigate("login") {
            popUpTo("home") { inclusive = true }  // remove splash from back stack
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Image(
            painter = painterResource(R.drawable.img),

            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    shape = CircleShape,
                    color = Color.Black
                ),
            contentDescription = "Image",
            alignment = Alignment.Center

        )


    }
}

@Preview(showSystemUi = true)
@Composable
fun USinup() {
    val navController = rememberNavController()
  Home(navController)
}