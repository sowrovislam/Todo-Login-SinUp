package com.example.todonot.uipage

import android.graphics.Paint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todonot.R
import com.example.todonot.navigation.Screen
import com.example.todonot.viewmodel.AuthViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Login(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

   val viewModel: AuthViewModel= viewModel()

// show err
    val authState by viewModel.authState.collectAsState()




    val systemUiController =rememberSystemUiController()

    SideEffect {
        systemUiController.isStatusBarVisible = false
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {



        Image(
            painter = painterResource(id = R.drawable.img_1), // your background drawable
            contentDescription = "Background",
            contentScale = ContentScale.Crop, // fill entire Box
            modifier = Modifier.fillMaxSize()
        )

        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(0.9f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
            containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp),


            ) {


            Column(

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))


                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Background Image",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(
                            width = 3.dp,
                            color = Color.Black,
                            shape = (CircleShape)

                        )

                )


                Text(
                    text = "Login",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))


                OutlinedTextField(
                    textStyle = LocalTextStyle.current.copy(color = Color.Black),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Inpur Email", color = Color.Black) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(17.dp))


                OutlinedTextField(
                    textStyle = LocalTextStyle.current.copy(color = Color.Black),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(
                        "Inpur Password",
                        color =Color.Black


                    )

                            },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),


                )

                Spacer(modifier = Modifier.height(16.dp))

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


                Spacer(modifier = Modifier.height(17.dp))
                Button(
                    onClick = {


                        viewModel.Login(email,password)




                    },
                    modifier = Modifier
                        .height(50.dp)
                        .width(200.dp),

                    shape = RoundedCornerShape(10.dp)


                ) {

                    Text("Login")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "SignUp",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .clickable{
                            navController.navigate("Sinup")
                        }

                )
                Spacer(modifier = Modifier.height(20.dp))

            }
        }


    }
    LaunchedEffect(authState) {
        if (authState == "Login Success") {
            navController.navigate(Screen.MainWork.route) {
                popUpTo(Screen.Login.route) { inclusive = true }
            }
        }
    }




}

@Preview(showSystemUi = true)
@Composable
fun UtLogin() {
    val navController = rememberNavController()
    Login(navController)
}
