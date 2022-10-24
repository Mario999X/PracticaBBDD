package repository

import models.Empleado

interface EmpleadoRepository: CrudRepository<Empleado, Int>  {
}