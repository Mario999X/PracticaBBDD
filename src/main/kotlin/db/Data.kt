package db

import models.Departamento
import models.Empleado
import java.time.LocalDate

fun departamentosInit() = listOf(
    Departamento(
        id = 1,
        nombre = "TESTEO",
        presupuesto = 1.0
    ),
    Departamento(
        id = 2,
        nombre = "PRODUCCION",
        presupuesto = 0.5
    ),
    Departamento(
        id = 3,
        nombre = "Analisis De Mercado",
        presupuesto = 5.0
    )
)

fun empleadosInit() = listOf(
    Empleado(
        id = 1,
        nombre = "Norman",
        fechaAlta = LocalDate.parse("2022-05-20"),
        idDepartamento = 1
    ),
    Empleado(
        id = 2,
        nombre = "Alysys",
        fechaAlta = LocalDate.parse("2000-06-15"),
        idDepartamento = 3
    )
)
