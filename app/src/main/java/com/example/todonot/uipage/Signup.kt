package com.example.todonot.uipage

import android.app.Activity
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todonot.R
import com.example.todonot.navigation.Screen
import com.example.todonot.viewmodel.AuthViewModel

@Composable
fun Sinup(navController: NavHostController) {


    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, view).hide(WindowInsetsCompat.Type.statusBars())
    }


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: AuthViewModel = viewModel()


    // show err
    val authState by viewModel.authState.collectAsState()






    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Background Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp, color = Color.Black, shape = (CircleShape)

                    )

            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Login",
                fontSize = 35.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(30.dp))


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Inpur Email", color =Color.Black) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                textStyle = LocalTextStyle.current.copy(color = Color.Black) // or any colo
            )


            Spacer(modifier = Modifier.height(30.dp))


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Inpur Password", color = Color.Black) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = LocalTextStyle.current.copy(color = Color.Black)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Forgot Password",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
                    .padding(end = 50.dp)

            )

            Spacer(modifier = Modifier.height(30.dp))


            Button(
                onClick = {

                    viewModel.signUp(email, password)


                },
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                shape = RoundedCornerShape(10.dp),
//                enabled = email.isNotBlank() && password.isNotBlank()

            ) {

                Text(
                    text = "SinUP",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,

                )
            }


        }


    }


    // 🔹 Navigate after successful signup
    LaunchedEffect(authState) {
        if (authState == "Register Success") {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Sinup.route) { inclusive = true }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun UISinup() {
    val navController = rememberNavController()
    Login(navController)
}
