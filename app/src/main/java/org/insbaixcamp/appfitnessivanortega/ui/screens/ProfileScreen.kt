package org.insbaixcamp.appfitnessivanortega.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import org.insbaixcamp.appfitnessivanortega.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alcada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    editar: () -> Unit
) {
    Column() {
        // Caixa de foto, nom i email
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier.size(120.dp).clip(CircleShape).background(Color.Black)
            )
            Text(text = nom, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = email, fontSize = 16.sp, color = Color.Gray)
        }

        // Caixa de informació
        Card(Modifier.fillMaxWidth().padding(16.dp), shape = RoundedCornerShape(16.dp)) {
            Row(Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Text(text = "Edat", color = Color.Gray)
                    // Calcular edat a partir de la data de naixement (format "dd/mm/aaaa")
                    val calendar = Calendar.getInstance()
                    val currentYear = calendar.get(Calendar.YEAR)
                    val currentMonth = calendar.get(Calendar.MONTH) + 1
                    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

                    val birthDay = dataNaixement.substring(0, 2).toIntOrNull() ?: 1
                    val birthMonth = dataNaixement.substring(3, 5).toIntOrNull() ?: 1
                    val birthYear = dataNaixement.substring(6, 10).toIntOrNull() ?: currentYear

                    var edat = currentYear - birthYear
                    if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
                        edat--
                    }
                    Text(text = edat.toString(), fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text(text = "Genere", color = Color.Gray)
                    Text(text = genere, fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text(text = "Alçada", color = Color.Gray)
                    Text(text = "$alcada cm", fontWeight = FontWeight.Bold)
                }
                Column() {
                    Text(text = "Pes", color = Color.Gray)
                    Text(text = "$pes kg", fontWeight = FontWeight.Bold)
                }
            }
        }
    }


    // Caixa d'objectius
    Text("Objectius")
    Card(){
        Text(objectiu)
    }

    // Caixa de nivell d'activitat
    Text("Nivell d'activitat")
    Card() {
        Text(nivellActivitat)
    }

}

