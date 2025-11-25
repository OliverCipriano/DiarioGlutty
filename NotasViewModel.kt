package com.ejemplo.diarioglutty.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ejemplo.diarioglutty.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date






data class Nota(
    val id: Long,
    val texto: String,
    val fotoUri: Uri?,
    val fecha: String
)

class NotasViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = NoteRepository.get(app)


    val notas = repo.notesFlow()
        .map { list ->
            list.map {
                Nota(
                    id = it.id,
                    texto = it.text,
                    fotoUri = it.photoUri?.let(Uri::parse),
                    fecha = it.date ?: ""
                )
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun agregar(texto: String, foto: Uri?) = viewModelScope.launch {
        if (texto.isBlank() && foto == null) return@launch
        repo.add(
            text = texto,
            photoUri = foto?.toString(),
            date = fechaHoy()
        )
    }

    fun eliminar(id: Long) = viewModelScope.launch { repo.delete(id) }

    companion object {
        fun factory(app: Application) = viewModelFactory {
            initializer { NotasViewModel(app) }
        }
    }
}

private fun fechaHoy(): String {
    val fmt = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return fmt.format(Date())
}
