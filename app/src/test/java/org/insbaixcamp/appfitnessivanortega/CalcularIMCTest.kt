package org.insbaixcamp.appfitnessivanortega

import junit.framework.TestCase.assertEquals
import org.insbaixcamp.appfitnessivanortega.tools.CalcularIMC
import org.junit.Test

class CalcularIMCTest {
    @Test
    fun calcularIMCPesNormal(){
        var pesActual = 75.0
        var alcada = 175
        var imc = CalcularIMC.calcularIMC(pesActual, alcada)
        assertEquals(24.49, imc, 0.1)
    }

    @Test
    fun calcularIMCPesIgualInferiorCero(){
        var pesActual = -1.0
        var alcada = 175
        var imc = CalcularIMC.calcularIMC(pesActual, alcada)
        assertEquals(0.0, imc, 0.1)
    }

    @Test
    fun calcularIMCAlcadaIgualInferiorCero(){
        var pesActual = 75.0
        var alcada = -1
        var imc = CalcularIMC.calcularIMC(pesActual, alcada)
        assertEquals(0.0, imc, 0.1)
    }


}