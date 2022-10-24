package db

object Tables {

    fun createTableDepartamento() = """
        CREATE TABLE IF NOT EXISTS departamentos(
        id String PRIMARY KEY,
        nombre VARCHAR(255) NOT NULL,
        presupuesto INTEGER NOT NULL,
        )
    """.trimIndent()
}