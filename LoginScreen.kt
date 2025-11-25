package com.ejemplo.diarioglutty.ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ejemplo.diarioglutty.auth.LoginViewModel

@Composable
fun LoginScreen(
    nav: NavController,
    vm: LoginViewModel
) {
    val ui by vm.ui.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("El Diario de Glutty", style = MaterialTheme.typography.headlineMedium)
            Text(
                "Inicia sesión para ver tus notas",
                style = MaterialTheme.typography.bodyMedium
            )

            OutlinedTextField(
                value = ui.email,
                onValueChange = vm::onEmailChange,
                label = { Text("Correo") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = ui.password,
                onValueChange = vm::onPasswordChange,
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            if (ui.error != null) {
                Text(
                    text = ui.error ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Button(
                onClick = {
                    vm.login {
                        nav.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                },
                enabled = !ui.isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (ui.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Entrar")
                }
            }

            // Credenciales de prueba de la API reqres.in
            Text(
                text = "Prueba con: eve.holt@reqres.in / cualquier contraseña",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
