import db.DataBaseManager
import db.Tables
fun main (){

    println("Inicio de conexion con H2")
    initDb()
    println("Fin de conexion con H2")

}

private fun initDb(){

    DataBaseManager.open()

    DataBaseManager.createTables(Tables.createTableDepartamento())

    DataBaseManager.close()
}