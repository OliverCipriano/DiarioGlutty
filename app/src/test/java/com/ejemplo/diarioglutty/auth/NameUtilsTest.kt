package com.ejemplo.diarioglutty.auth

import org.junit.Assert.assertEquals
import org.junit.Test

class NameUtilsTest {

    @Test
    fun emailToDisplayNameConvierteCorrecto() {
        assertEquals(
            "Juan Perez",
            emailToDisplayName("juan.perez@correo.com")
        )
    }

    @Test
    fun emailToDisplayNameVacioDevuelveVacio() {
        assertEquals("", emailToDisplayName(""))
    }
}
