package controller

import models.Empleado
import mu.KotlinLogging
import repository.EmpleadoRepository

private val logger = KotlinLogging.logger {}

class EmpleadoController(private val empleadoRepository: EmpleadoRepository) {

    fun getEmpleados(): List<Empleado> {
        logger.info("Obteniendo Departamentos")
        return empleadoRepository.findAll()
    }

    fun createEmpleado(empleado: Empleado): Empleado {
        logger.debug { "Creando departamentos $empleado" }
        empleadoRepository.save(empleado)
        return empleado
    }

    fun getEmpleadoById(id: Int): Empleado? {
        logger.debug { "Obteniendo tenista con uuid $id" }
        return empleadoRepository.findById(id)
    }
}