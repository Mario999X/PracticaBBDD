package db

import models.Departamento

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
