import controller.DepartamentoController
import controller.EmpleadoController
import db.DataBaseManager
import db.Tables
import db.departamentosInit
import db.empleadosInit
import repository.DepartamentoRepositoryImpl
import repository.EmpleadoRepositoryImpl

fun main() {
    println("Inicio de conexion con H2")
    // FUNCION DE LA BBDD
    initDb()

    // --- CONTROLADORES ---
    val departamentoController = DepartamentoController(DepartamentoRepositoryImpl())
    val empleadoController = EmpleadoController(EmpleadoRepositoryImpl())

    // --- DEPARTAMENTOS ---
    // Comenzamos con la creacion de los departamentos y su introduccion a la tabla departamentos
    departamentosInit().forEach { departamento ->
        departamentoController.createDepartamento(departamento)
    }

    // Obtenemos los departamentos de la tabla departamentos
    val departamentos = departamentoController.getDepartamentos()
    println("Listado de departamentos: \n$departamentos")

    // Obtenemos los departamentos ordenados por presupuesto
    val departamentosOrdenados = departamentoController.getDepartamentos().sortedByDescending { it.presupuesto }
    println("Ordenado por presupuesto: \n$departamentosOrdenados")

    // Obtenemos un departamento con un ID
    val departamentoId = departamentoController.getDepartamientoById(1)
    println("Departamento con ID especifico: $departamentoId")

    // Actualizamos el presupuesto del departamento elegido
    departamentoId?.let { it.presupuesto = 1000.0
    departamentoController.updateDepartamento(it)}
    println("Departamento actualizado: $departamentoId")

    // --- EMPLEADOS ---
    // Cargamos a los empleados en la tabla empleados
    empleadosInit().forEach { empleado ->
        empleadoController.createEmpleado(empleado)
    }

    // Obtenemos los empleados de la tabla empleados
    val empleados = empleadoController.getEmpleados()
    println("Listado de empleados: \n$empleados")

    // Obtenemos el empleado con un ID
    val empleadoId = empleadoController.getEmpleadoById(1)
    println("Empleado con ID especifico: $empleadoId")

    // Eliminamos el empleado con el ID anterior
    empleadoId?.let { if (empleadoController.deleteEmpleado(it)) println("${it.nombre} ha sido eliminado, con id ${it.id}") }


    println("Fin de conexion con H2")
}

private fun initDb() {
    DataBaseManager.open()
    DataBaseManager.createTables(Tables.createTableDepartamento())
    DataBaseManager.createTables(Tables.createTableEmpleado())
    DataBaseManager.close()
}