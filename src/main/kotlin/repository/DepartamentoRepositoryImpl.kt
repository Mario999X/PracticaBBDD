package repository

import db.DataBaseManager
import models.Departamento

class DepartamentoRepositoryImpl: DepartamentoRepository {

    override fun findAll(): List<Departamento>{
        DataBaseManager.open()
        // Ejecutamos la consulta
        val result = DataBaseManager.select("SELECT * FROM departamentos")
        // Creamos lista de departamentos
        val departamentos = mutableListOf<Departamento>()

        // Recorremos el resultado
        result?.let{
            while (result.next()) {
                // Creamos el departamento
                val departamento = Departamento(
                    id = it.getInt("id"),
                    nombre = it.getString("nombre"),
                    presupuesto = it.getDouble("presupuesto")
                )

                // Añadimos el departamento a la lista
                departamentos.add(departamento)
            }
        }
        DataBaseManager.close()
        return departamentos.toList()
    }

    override fun findById(id: Int): Departamento? {
        DataBaseManager.open()
        // Ejecutamos la consulta
        val result = DataBaseManager.select("SELECT * FROM departamentos WHERE id = ?", id)
        var departamento: Departamento? = null

        result?.let{
            if (result.next()){
                departamento = Departamento(
                    id = result.getInt("id"),
                    nombre = it.getString("nombre"),
                    presupuesto = it.getDouble("presupuesto")
                )
            }
        }

        DataBaseManager.close()
        return departamento
    }

    override fun save(entity: Departamento): Departamento {
        val departamento = findById(entity.id)
        departamento?.let {
            return update(entity)
        } ?: run {
            return insert(entity)
        }
    }

    override fun delete(entity: Departamento): Boolean {
        DataBaseManager.open()
        val result = DataBaseManager.delete("DELETE FROM departamentos WHERE id = ?", entity.id)
        DataBaseManager.close()
        return result == 1
    }

    private fun insert(departamento: Departamento): Departamento {
        // Creamos la consulta
        val query = """INSERT INTO departamentos
            (id, nombre, presupuesto)
            VALUES (?,?,?)""".trimMargin()
        // Ejecutamos consulta
        DataBaseManager.open()
        DataBaseManager.insert(
            query, departamento.id, departamento.nombre, departamento.presupuesto
        )
        DataBaseManager.close()
        return departamento
    }

    private fun update(departamento: Departamento): Departamento{
        val query = """UPDATE departamentos
            SET nombre = ?, presupuesto = ?
            WHERE id = ?""".trimMargin()
        // Ejecutamos consulta
        DataBaseManager.open()
        DataBaseManager.update(
            query, departamento.nombre, departamento.presupuesto, departamento.id
        )
        DataBaseManager.close()
        return departamento
    }
}