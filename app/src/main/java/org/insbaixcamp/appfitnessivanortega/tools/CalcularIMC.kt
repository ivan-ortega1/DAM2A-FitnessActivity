package org.insbaixcamp.appfitnessivanortega.tools

import kotlin.math.round

class CalcularIMC {
    companion object {
        fun calcularIMC(pesActual: Double, alcada: Int): Double {
            if (pesActual <= 0.0 || alcada <= 0) {
                return 0.0
            }
            var alcadaMetres = alcada.toDouble() / 100
            return round(pesActual / (alcadaMetres * alcadaMetres)*100)/100
        }
    }
}