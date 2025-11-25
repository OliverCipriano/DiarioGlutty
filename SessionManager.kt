package com.ejemplo.diarioglutty.auth

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "glutty_prefs")

class SessionManager(private val context: Context) {

    private val KEY_LOGGED_IN = booleanPreferencesKey("logged_in")
    private val KEY_TOKEN = stringPreferencesKey("token")
    private val KEY_EMAIL = stringPreferencesKey("email")

    suspend fun saveSession(token: String, email: String) { // guardado de sesion save
        context.dataStore.edit { prefs ->
            prefs[KEY_LOGGED_IN] = true
            prefs[KEY_TOKEN] = token
            prefs[KEY_EMAIL] = email
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit { prefs ->
            prefs[KEY_LOGGED_IN] = false
            prefs[KEY_TOKEN] = ""
            prefs[KEY_EMAIL] = ""
        }
    }

    suspend fun isLoggedIn(): Boolean {
        return context.dataStore.data
            .map { prefs -> prefs[KEY_LOGGED_IN] ?: false }
            .first()
    }

    suspend fun getEmail(): String? {
        return context.dataStore.data
            .map { prefs -> prefs[KEY_EMAIL] }
            .first()
    }

    suspend fun getToken(): String? {
        return context.dataStore.data
            .map { prefs -> prefs[KEY_TOKEN] }
            .first()
    }
}
