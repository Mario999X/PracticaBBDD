package controller

import models.Departamento
import mu.KotlinLogging
import repository.DepartamentoRepository

private val logger = KotlinLogging.logger {}

class DepartamentoController(private val departamentoRepository: DepartamentoRepository) {

    fun getDepartamentos(): List<Departamento> {
        logger.info("Obteniendo Departamentos")
        return departamentoRepository.findAll()
    }

    fun createDepartamento(departamento: Departamento): Departamento {
        logger.debug { "Creando departamentos $departamento" }
        departamentoRepository.save(departamento)
        return departamento
    }

    fun getDepartamientoById(id: Int): Departamento? {
        logger.debug { "Obteniendo tenista con uuid $id" }
        return departamentoRepository.findById(id)
    }

}