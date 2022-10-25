package models

import java.time.LocalDate

data class Empleado(
    var id: Int = 0,
    var nombre: String,
    var fechaAlta: LocalDate,
    var idDepartamento: Int = 0
)
