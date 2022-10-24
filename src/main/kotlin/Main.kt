import controller.DepartamentoController
import db.DataBaseManager
import db.Tables
import db.departamentosInit
import repository.DepartamentoRepositoryImpl

fun main() {
    println("Inicio de conexion con H2")
    initDb()

    val controller = DepartamentoController(DepartamentoRepositoryImpl())

    // Comenzamos con la creacion de los departamentos y su introduccion a la tabla departamentos
    departamentosInit().forEach { departamento ->
        controller.createDepartamento(departamento)
    }

    // Obtenemos los departamentos de la tabla departamentos
    val departamentos = controller.getDepartamentos()
    println("Listado de departamentos: \n$departamentos")

    // Obtenemos los departamentos ordenados por presupuesto
    val departamentosOrdenados = controller.getDepartamentos().sortedByDescending { it.presupuesto }
    println("Ordenado por presupuesto: \n$departamentosOrdenados")

    // Obtenemos un departamento con un ID
    val departamentoId = controller.getDepartamientoById(3)
    println("Departamento con ID especifico: $departamentoId")

    println("Fin de conexion con H2")
}

private fun initDb() {

    DataBaseManager.open()
    DataBaseManager.createTables(Tables.createTableDepartamento())
    DataBaseManager.close()
}