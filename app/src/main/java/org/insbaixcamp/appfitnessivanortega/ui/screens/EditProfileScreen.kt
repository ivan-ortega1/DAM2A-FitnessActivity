package org.insbaixcamp.appfitnessivanortega.ui.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessivanortega.R
import org.w3c.dom.Text

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alcada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: () -> Unit,
    canviarFoto: () -> Unit,
    elimiinarFoto: () -> Unit
) {
    Column() {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
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
        Card(Modifier
            .fillMaxWidth()
            .padding(16.dp), shape = RoundedCornerShape(16.dp)) {
            TextField(
                state = TextFieldState(initialText = nom), Modifier.fillMaxWidth(),
                label = { Text("Nom complet") }
            )
            TextField(
                state = TextFieldState(initialText = email), Modifier.fillMaxWidth(),
                label = { Text("Correu electrònic") }
            )
            TextField(
                state = TextFieldState(initialText = dataNaixement), Modifier.fillMaxWidth(),
                label = { Text("Data de naixement") }
            )
            TextField(
                state = TextFieldState(initialText = genere), Modifier.fillMaxWidth(),
                label = { Text("Gènere") }
            )
        }

    }
}

