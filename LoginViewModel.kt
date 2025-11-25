package com.ejemplo.diarioglutty.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)

class LoginViewModel(
    private val repo: AuthRepository
) : ViewModel() {

    private val _ui = MutableStateFlow(LoginUiState())
    val ui: StateFlow<LoginUiState> = _ui

    fun onEmailChange(v: String) {
        _ui.value = _ui.value.copy(email = v, error = null)
    }

    fun onPasswordChange(v: String) {
        _ui.value = _ui.value.copy(password = v, error = null)
    }

    fun login(onSuccess: () -> Unit) {
        val email = _ui.value.email.trim()
        val pass = _ui.value.password

        if (email.isEmpty() || pass.isEmpty()) {
            _ui.value = _ui.value.copy(error = "Completa correo y contraseña")
            return
        }

        viewModelScope.launch {
            _ui.value = _ui.value.copy(isLoading = true, error = null)
            val result = repo.login(email, pass)
            _ui.value = _ui.value.copy(isLoading = false)

            result.onSuccess {
                onSuccess()
            }.onFailure { e ->
                _ui.value = _ui.value.copy(
                    error = e.message ?: "Error al iniciar sesión"
                )
            }
        }
    }

    companion object {
        fun provideFactory(repo: AuthRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                    return LoginViewModel(repo) as T
                }
            }
    }
}
