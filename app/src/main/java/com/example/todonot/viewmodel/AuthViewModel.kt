package com.example.todonot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<String?>(null)

    val authState: StateFlow<String?> = _authState


    fun signUp(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = "Email and Password must not be empty"
            return
        }

        _authState.value = "Loading..."
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = "Register Success"
                } else {
                    _authState.value = task.exception?.message
                }
            }
    }

    fun Login(email: String, password: String) {


        if (email.isBlank() || password.isBlank()) {
            _authState.value = "Email and Password must not be empty"
            return
        }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        _authState.value = "Login Success"
                    } else {

                        _authState.value = task.exception?.message


                    }

                }


        }






        fun LogOut(){

            auth.signOut()
            _authState.value="Legged Out"
//            Login(email,password)


        }





}