package models

import java.time.LocalDate

data class Empleado(
    val id: Int = 0,
    val nombre: String,
    val fechaAlta: LocalDate,
    val idDepartamento: Int = 0
)
