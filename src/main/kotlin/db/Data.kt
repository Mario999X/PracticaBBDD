package db

import models.Departamento

fun departamentosInit() = listOf(
    Departamento(
        id = 1,
        nombre = "TESTEO",
        presupuesto = 1,
    )
)