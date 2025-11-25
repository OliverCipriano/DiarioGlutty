package com.ejemplo.diarioglutty.auth

class AuthRepository(
    private val api: ApiService,
    private val sessionManager: SessionManager //guardado de sesion
) {


    suspend fun login(email: String, password: String): Result<Unit> {
        return try {


            val response = api.login(LoginRequest(email, password))


            if (response.isSuccessful) {
                val body = response.body()
                if (body != null && body.token.isNotBlank()) {
                    sessionManager.saveSession(body.token, email)
                    return Result.success(Unit)
                } else {
                    return Result.failure(Exception("Respuesta vacía del servidor"))
                }
            }

            val demoEmail = "eve.holt@reqres.in"
            val demoPass  = "cody"

            if (email == demoEmail && password == demoPass) {
                sessionManager.saveSession("token-demo-local", email)
                return Result.success(Unit)
            }

            Result.failure(Exception("Credenciales invalidas (${response.code()})"))

        } catch (e: Exception) {

            Result.failure(Exception("Error de red: ${e.message}"))
        }
    }

    suspend fun logout() {
        sessionManager.clearSession()
    }
}
