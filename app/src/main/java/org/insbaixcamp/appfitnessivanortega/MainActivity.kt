package org.insbaixcamp.appfitnessivanortega

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.appfitnessivanortega.ui.screens.EditProfileScreen
import org.insbaixcamp.appfitnessivanortega.ui.screens.ProfileScreen
import org.insbaixcamp.appfitnessivanortega.ui.theme.AppFitnessIvanOrtegaTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessIvanOrtegaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FitnessApp()
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom: String by remember { mutableStateOf("Iván Ortega") }
    var email: String by remember { mutableStateOf("ivan.ortega1@insbaixcamp.cat") }
    var dataNaixement: String by remember { mutableStateOf("16/10/1999") }
    var genere: String by remember { mutableStateOf("Home") }
    var alcada: Int by remember { mutableStateOf(170) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var objectiu:String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat:String by remember { mutableStateOf("Moderat") }
    var editant: Boolean by remember { mutableStateOf(true) }
    var fotoPerfil: Int by remember {
        mutableIntStateOf(R.drawable.ic_launcher_background)
    }

    if (editant) {
        EditProfileScreen(nom, email, dataNaixement, genere, alcada, pes, objectiu, nivellActivitat, {editant = false }, { fotoPerfil = R.drawable.ic_launcher_foreground }, { fotoPerfil = R.drawable.ic_launcher_background })
    } else {
        ProfileScreen(nom, email, dataNaixement, genere, alcada, pes, objectiu, nivellActivitat, fotoPerfil, { editant = true })

        /**
         * fun editar(){editant=true}
         * {editant=true}
         */
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    AppFitnessIvanOrtegaTheme {
        FitnessApp()
    }
}