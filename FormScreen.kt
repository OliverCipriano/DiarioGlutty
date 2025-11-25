package com.ejemplo.diarioglutty.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ejemplo.diarioglutty.viewmodel.NotasViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(nav: NavController, vm: NotasViewModel) {
    var texto by rememberSaveable { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Nueva entrada") }) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    if (texto.isBlank()) {
                        error = "Escribe algo para guardar la entrada."
                    } else {
                        vm.agregar(texto, null)
                        nav.popBackStack()
                    }
                },
                icon = { Icon(Icons.Default.Add, contentDescription = "Guardar entrada") },
                text = { Text("Guardar entrada") }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = texto,
                onValueChange = {
                    texto = it
                    if (it.isNotBlank()) error = null
                },
                label = { Text("Escribe tu entrada…") },
                isError = error != null,
                modifier = Modifier.fillMaxWidth()
            )
            AnimatedVisibility(visible = error != null) {
                Text(error ?: "", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}
