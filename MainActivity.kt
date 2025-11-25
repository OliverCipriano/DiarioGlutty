package com.ejemplo.diarioglutty

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ejemplo.diarioglutty.auth.AuthRepository
import com.ejemplo.diarioglutty.auth.LoginViewModel
import com.ejemplo.diarioglutty.auth.SessionManager
import com.ejemplo.diarioglutty.auth.provideApiService
import com.ejemplo.diarioglutty.ui.FormScreen
import com.ejemplo.diarioglutty.ui.HomeScreen
import com.ejemplo.diarioglutty.ui.LoginScreen
import com.ejemplo.diarioglutty.ui.SplashScreen
import com.ejemplo.diarioglutty.viewmodel.NotasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val nav = rememberNavController()

            //Room
            val notasVm: NotasViewModel = viewModel(
                factory = NotasViewModel.factory(application as Application)
            )


            val context = LocalContext.current
            val sessionManager = SessionManager(context)
            val apiService = provideApiService()
            val authRepo = AuthRepository(apiService, sessionManager) // autenticación

            // ViewModel de login
            val loginVm: LoginViewModel = viewModel(
                factory = LoginViewModel.provideFactory(authRepo)
            )

            MaterialTheme {
                Surface(Modifier.fillMaxSize()) {
                    NavHost(navController = nav, startDestination = "splash") {
                        composable("splash") { SplashScreen(nav) }
                        composable("login")  { LoginScreen(nav = nav, vm = loginVm) }
                        composable("home")   { HomeScreen(nav = nav, vm = notasVm) }
                        composable("form")   { FormScreen(nav = nav, vm = notasVm) }
                    }
                }
            }
        }
    }
}