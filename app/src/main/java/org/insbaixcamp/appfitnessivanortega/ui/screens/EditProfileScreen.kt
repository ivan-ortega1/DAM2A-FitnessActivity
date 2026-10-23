package org.insbaixcamp.appfitnessivanortega.ui.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessivanortega.R
import org.insbaixcamp.appfitnessivanortega.ui.components.CalendariPicker
import org.insbaixcamp.appfitnessivanortega.ui.components.MenuDesplegable
import org.w3c.dom.Text

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alcada: Int,
    pes: Double,
    pesObjectiu: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, String, String, Int, Double, Double, String, String) -> Unit,
    canviarFoto: () -> Unit,
    elimiinarFoto: () -> Unit
) {

    var nomNou: String by remember { mutableStateOf(nom) }
    var emailNou: String by remember { mutableStateOf(email) }
    var dataNaixementNou: String by remember { mutableStateOf(dataNaixement) }
    var genereNou: String by remember { mutableStateOf(genere) }
    var alcadaNou: Int by remember { mutableStateOf(alcada) }
    var pesNou: Double by remember { mutableStateOf(pes) }
    var pesObjectiuNou: Double by remember { mutableStateOf(pesObjectiu) }
    var objectiuNou: String by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou: String by remember { mutableStateOf(nivellActivitat) }

    var opcionsGenere = listOf("Home", "Dona", "No em identifico", "Prefereixo no dir-ho")
    var opcionsObjectiu = listOf("Guanyar massa muscular", "Redueix pes", "Manté el meu pes")

    Column() {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier
                    .padding(start = 8.dp)
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Column(Modifier.fillMaxWidth().padding(end = 8.dp), horizontalAlignment = Alignment.End) {
                Button(onClick = { canviarFoto() }, Modifier.width(170.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.camera_front),
                        contentDescription = null,
                        Modifier
                            .size(22.dp)

                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Canviar Foto")
                }
                Spacer(modifier = Modifier.size(8.dp))
                Button(onClick = { elimiinarFoto() }, Modifier.width(170.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.trash_delete_bin),
                        contentDescription = null,
                        Modifier
                            .size(22.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = "Eliminar Foto")
                }
            }
        }
        Text(text = "Dades personals", fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp))
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        // Data naixement
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou.toLongOrNull(),
            onDateSelected = { dataNaixementNou = it.toString() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Génere
        MenuDesplegable(
            label = "Gènere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Text(text = "Dades físiques", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, start = 8.dp))
        Row() {
            OutlinedTextField(
                value = alcadaNou.toString(),
                onValueChange = { alcadaNou = it.toIntOrNull() ?: 0 },
                label = { Text("Alçada (cm)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            OutlinedTextField(
                value = pesNou.toString(),
                onValueChange = { pesNou = it.toDoubleOrNull() ?: 0.0 },
                label = { Text("Pes (kg)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            OutlinedTextField(
                value = pesObjectiuNou.toString(),
                onValueChange = { pesObjectiuNou = it.toDoubleOrNull() ?: 0.0 },
                label = { Text("Objectiu de pes (kg)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

        }

        Text(text = "Objectiu principal", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, start = 8.dp))
        MenuDesplegable(
            label = "Objectiu",
            opcions = opcionsObjectiu,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(modifier = Modifier.fillMaxWidth().padding(8.dp), onClick = { guardar(nomNou, emailNou, dataNaixementNou, genereNou, alcadaNou, pesNou, pesObjectiuNou, objectiuNou, nivellActivitatNou)}){
            Text("Guardar dades")
        }

    }
}

