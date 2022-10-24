package models

import java.time.LocalDate
import java.util.UUID

data class Empleado(
    val id: UUID = UUID.randomUUID(),
    val nome: String,
    val fechaAlta: LocalDate
)
