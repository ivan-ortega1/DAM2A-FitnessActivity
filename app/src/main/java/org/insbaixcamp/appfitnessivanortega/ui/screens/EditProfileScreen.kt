package org.insbaixcamp.appfitnessivanortega.ui.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
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
    guardar: () -> Unit
) {
    Column() {
        Row() {
            Image()
            Column() {
                Button() {
                    Text =
                }
                Button(){
                    Text =
                }
            }
        }
    }
}
