package repository

import db.DataBaseManager
import models.Empleado
import java.time.LocalDate

class EmpleadoRepositoryImpl : EmpleadoRepository {

    override fun findAll(): List<Empleado> {
        DataBaseManager.open()
        // Ejecutamos la consulta
        val result = DataBaseManager.select("SELECT * FROM empleados")
        // Creamos lista de departamentos
        val empleados = mutableListOf<Empleado>()

        // Recorremos el resultado
        result?.let {
            while (result.next()) {
                // Creamos el departamento
                val empleado = Empleado(
                    id = it.getInt("id"),
                    nombre = it.getString("nombre"),
                    fechaAlta = LocalDate.parse(it.getObject("fecha_alta").toString()),
                    idDepartamento = result.getInt("id_departamento")
                )

                // Añadimos el departamento a la lista
                empleados.add(empleado)
            }
        }
        DataBaseManager.close()
        return empleados.toList()
    }

    override fun findById(id: Int): Empleado? {
        DataBaseManager.open()
        // Ejecutamos la consulta
        val result = DataBaseManager.select("SELECT * FROM empleados WHERE id = ?", id)
        var empleado: Empleado? = null

        result?.let {
            if (result.next()) {
                empleado = Empleado(
                    id = it.getInt("id"),
                    nombre = it.getString("nombre"),
                    fechaAlta = LocalDate.parse(it.getObject("fecha_alta").toString()),
                    idDepartamento = result.getInt("id_departamento")
                )
            }
        }

        DataBaseManager.close()
        return empleado
    }

    override fun save(entity: Empleado): Empleado {
        val empleado = findById(entity.id)
        empleado?.let {
            return update(entity)
        } ?: run {
            return insert(entity)
        }
    }

    private fun insert(empleado: Empleado): Empleado {
        // Creamos la consulta
        val query = """INSERT INTO empleados
            (id, nombre, fecha_alta, id_departamento)
            VALUES (?,?,?,?)""".trimMargin()
        // Ejecutamos consulta
        DataBaseManager.open()
        DataBaseManager.insert(
            query, empleado.id, empleado.nombre, empleado.fechaAlta, empleado.idDepartamento
        )
        DataBaseManager.close()
        return empleado
    }

    private fun update(empleado: Empleado): Empleado {
        val query = """UPDATE empleados
            SET nombre = ?, fecha_alta = ?, id_departamento = ?
            WHERE id = ?""".trimMargin()
        // Ejecutamos consulta
        DataBaseManager.open()
        DataBaseManager.update(
            query, empleado.nombre, empleado.fechaAlta, empleado.idDepartamento, empleado.id
        )
        DataBaseManager.close()
        return empleado
    }
}