package models

import java.util.*

data class Departamento(
    val id: UUID = UUID.randomUUID(),
    val nombre : String = "",
    val presupuesto: Long = 0,
    // Donde se guardan los empleados
    val listadoEmpleado: List<Empleado>
)
