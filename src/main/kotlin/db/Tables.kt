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