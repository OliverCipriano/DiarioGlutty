package com.ejemplo.diarioglutty.auth


fun emailToDisplayName(email: String): String {
    val raw = email.trim().substringBefore("@")
    if (raw.isBlank()) return ""
    return raw
        .split(".", "_", "-", " ")
        .filter { it.isNotBlank() }
        .joinToString(" ") { part ->
            part.lowercase().replaceFirstChar { it.uppercase() }
        }
}