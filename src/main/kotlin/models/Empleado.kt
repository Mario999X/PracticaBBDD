package models

import java.time.LocalDate

data class Empleado(
    val id: Int = 0,
    val nome: String,
    val fechaAlta: LocalDate
)
