package models

data class Departamento(
    val id: Int =  0,
    val nombre : String = "",
    val presupuesto: Double = 0.0,
    // Donde se guardan los empleados
    //val listadoEmpleado: List<Empleado>
)
