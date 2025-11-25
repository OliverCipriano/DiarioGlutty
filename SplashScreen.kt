package com.ejemplo.diarioglutty.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.ejemplo.diarioglutty.R
import com.ejemplo.diarioglutty.auth.SessionManager
import kotlinx.coroutines.delay
import androidx.compose.ui.platform.LocalContext

@Composable
fun SplashScreen(nav: NavController) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val session = SessionManager(context)
        delay(1500)
        val loggedIn = session.isLoggedIn()

        nav.navigate(if (loggedIn) "home" else "login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Surface(
        color = Color(0xFF101010),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo3),
                contentDescription = "Pantalla de carga",
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f),
                contentScale = ContentScale.Fit
            )
        }
    }
}