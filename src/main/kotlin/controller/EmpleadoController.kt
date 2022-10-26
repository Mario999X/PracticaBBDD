package controller

import db.departamentosInit
import models.Empleado
import mu.KotlinLogging
import repository.DepartamentoRepositoryImpl
import repository.EmpleadoRepository

private val logger = KotlinLogging.logger {}

private val departamentoController = DepartamentoController(DepartamentoRepositoryImpl())

class EmpleadoController(private val empleadoRepository: EmpleadoRepository) {

    fun getEmpleados(): List<Empleado> {
        logger.info("Obteniendo Empleados")
        return empleadoRepository.findAll()
    }

    fun createEmpleado(empleado: Empleado): Empleado {
        departamentosInit().forEach { departamento ->
            departamentoController.createDepartamento(departamento)
        }
        val departamentos = empleado.idDepartamento.let { departamentoController.getDepartamientoById(it) }
        require(departamentos != null) {"El departamento ${empleado.idDepartamento} no existe"}
        logger.debug { "Creando empleado $empleado" }
        empleadoRepository.save(empleado)
        return empleado
    }

    fun getEmpleadoById(id: Int): Empleado? {
        logger.debug { "Obteniendo empleado con uuid $id" }
        return empleadoRepository.findById(id)
    }

    fun updateEmpleado(empleado: Empleado) {
        logger.debug { "Actualizando empleado $empleado" }
        empleadoRepository.save(empleado)
    }

    fun deleteEmpleado(it: Empleado): Boolean {
        logger.debug { "Borrando empleado $it" }
        return empleadoRepository.delete(it)
    }
}