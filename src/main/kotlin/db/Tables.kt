package db

object Tables {

    fun createTableDepartamento() = """
        CREATE TABLE IF NOT EXISTS departamentos(
        id INTEGER PRIMARY KEY,
        nombre VARCHAR(255) NOT NULL,
        presupuesto REAL NOT NULL
        )
    """.trimIndent()

    fun createTableEmpleado() = """
        CREATE TABLE IF NOT EXISTS empleados(
        id INTEGER PRIMARY KEY,
        nombre VARCHAR(255) NOT NULL,
        fecha_alta DATE NOT NULL,
        id_departamento INT REFERENCES departamentos(id)
        )
    """.trimIndent()
}

/**
 * 1.Caso: uno con libertad de eliminación del departamento (y dejar a empleados sin departamento como null)
 *  - En el modelo empleado, dejar el idDepartamento como int?
 *  - En la tabla de empleados ON DELETE SET NULL en id_departamento
 *
 *  2.Caso: Literalmente como esta el programa ahora mismo.
 *   - Mencion al require del EmpleadoController (en el primer caso, comentado)
 */