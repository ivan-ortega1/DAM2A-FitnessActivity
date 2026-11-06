package org.insbaixcamp.appfitnessivanortega.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessivanortega.tools.CalcularIMC
import org.insbaixcamp.appfitnessivanortega.ui.theme.AppFitnessIvanOrtegaTheme

@Composable
fun WeightTrackingScreen (
    pesActual: Double,
    pesObjectiu: Double,
    alcada: Int
){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 16.dp)) {
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "Pes actual")
                Text(text = "$pesActual kg")
            }
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "Pes objectiu ")
                Text(text = "$pesObjectiu kg")
            }
            Card(Modifier.weight(1f).padding(8.dp)) {
                Text(text = "IMC")
                var imc = CalcularIMC.calcularIMC(pesActual, alcada)
                Text(text = "$imc")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrackingScreenPreview() {
    AppFitnessIvanOrtegaTheme {
        WeightTrackingScreen(
            pesActual = 75.0,
            pesObjectiu = 70.0,
            alcada = 175
        )
    }
}

