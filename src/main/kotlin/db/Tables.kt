package db

object Tables {

    fun createTableDepartamento() = """
        CREATE TABLE IF NOT EXISTS departamentos(
        id INTEGER PRIMARY KEY,
        nombre VARCHAR(255) NOT NULL,
        presupuesto REAL NOT NULL
        )
    """.trimIndent()
}