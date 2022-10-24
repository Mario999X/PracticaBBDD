package repository

import models.Departamento

interface DepartamentoRepository: CrudRepository<Departamento, Int> {
}