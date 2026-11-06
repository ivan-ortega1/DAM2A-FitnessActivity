package org.insbaixcamp.appfitnessivanortega.tools

import kotlin.math.round

class CalcularIMC {
    companion object {
        fun calcularIMC(pesActual: Double, alcada: Int): Double {
            var alcadaMetres = alcada.toDouble() / 100
            return round(pesActual / (alcadaMetres * alcadaMetres)*100)/100
        }
    }
}