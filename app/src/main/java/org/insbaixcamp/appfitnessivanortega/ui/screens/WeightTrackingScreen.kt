package org.insbaixcamp.appfitnessivanortega.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitnessivanortega.model.WeightTracking
import org.insbaixcamp.appfitnessivanortega.tools.CalcularIMC
import org.insbaixcamp.appfitnessivanortega.ui.components.WeightTrackingItem
import org.insbaixcamp.appfitnessivanortega.ui.theme.AppFitnessIvanOrtegaTheme

@Composable
fun WeightTrackingScreen(
    pesActual: Double,
    pesObjectiu: Double,
    alcada: Int
) {
    val tag = "WeightTrackingScreen"
    val weightTrackingList = remember { mutableStateListOf<WeightTracking>() }
    var pesNouText by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Row(Modifier.padding(top = 16.dp)) {
                Card(
                    Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(text = "Pes actual")
                        Text(text = "$pesActual kg")
                    }
                }
                Card(
                    Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(text = "Pes objectiu ")
                        Text(text = "$pesObjectiu kg")
                    }
                }
                Card(
                    Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(text = "IMC")
                        val imc = CalcularIMC.calcularIMC(pesActual, alcada)
                        Text(text = "$imc")
                    }
                }
            }
        }

        item {
            Text(
                text = "Registrar un nou pes",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp),
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                value = pesNouText,
                onValueChange = { pesNouText = it },
                label = { Text("Nou pes (kg)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
            Button(
                onClick = {
                    val pesNou = pesNouText.toDoubleOrNull()
                    if (pesNou != null) {
                        val data = System.currentTimeMillis()
                        weightTrackingList.add(WeightTracking(data, pesNou))
                        Log.i(tag, "Object weightTracking: $weightTrackingList")
                        pesNouText = ""
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text("Guardar pes")
            }
        }

        item {
            Text(
                text = "Evolució del pes",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
        }

        item {
            Text(
                text = "Últims registres",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp)
            )
        }

        items(
            items = weightTrackingList,
            key = { it.date }
        ) { weightTracking ->
            WeightTrackingItem(weightTracking)
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
