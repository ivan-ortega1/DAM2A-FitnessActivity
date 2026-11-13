package org.insbaixcamp.appfitnessivanortega

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitnessivanortega.ui.screens.EditProfileScreen
import org.insbaixcamp.appfitnessivanortega.ui.screens.ProfileScreen
import org.insbaixcamp.appfitnessivanortega.ui.screens.WeightTrackingScreen
import org.insbaixcamp.appfitnessivanortega.ui.theme.AppFitnessIvanOrtegaTheme

enum class AppScreen(val title: String, val icon: ImageVector) {
    PROFILE("Perfil", Icons.Default.Person),
    WEIGHT("Pes", Icons.Default.MonitorWeight),
    ROUTINE("Rutina", Icons.Default.FitnessCenter)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessIvanOrtegaTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var currentScreen by remember { mutableStateOf(AppScreen.PROFILE) }

    var nom: String by remember { mutableStateOf("Iván Ortega") }
    var email: String by remember { mutableStateOf("ivan.ortega1@insbaixcamp.cat") }
    var dataNaixement: String by remember { mutableStateOf("16/10/1999") }
    var genere: String by remember { mutableStateOf("Home") }
    var alcada: Int by remember { mutableStateOf(170) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var pesObjectiu: Double by remember { mutableStateOf(60.0) }
    var objectiu: String by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat: String by remember { mutableStateOf("Moderat") }
    var editant: Boolean by remember { mutableStateOf(false) }
    var fotoPerfil: Int by remember {
        mutableIntStateOf(R.drawable.ic_launcher_background)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                AppScreen.entries.forEach { screen ->
                    NavigationBarItem(
                        selected = currentScreen == screen,
                        onClick = { currentScreen = screen },
                        label = { Text(screen.title) },
                        icon = { Icon(screen.icon, contentDescription = screen.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (currentScreen) {
                AppScreen.PROFILE -> {
                    if (editant) {
                        EditProfileScreen(
                            nom, email, dataNaixement, genere, alcada, pes, pesObjectiu, objectiu, nivellActivitat,
                            { nomN, emailN, dataNaixementN, genereN, alcadaN, pesN, pesObjectiuN, objectiuN, nivellActivitatN ->
                                nom = nomN
                                email = emailN
                                dataNaixement = dataNaixementN
                                genere = genereN
                                alcada = alcadaN
                                pes = pesN
                                pesObjectiu = pesObjectiuN
                                objectiu = objectiuN
                                nivellActivitat = nivellActivitatN
                                editant = false
                            },
                            { fotoPerfil = R.drawable.ic_launcher_foreground },
                            { fotoPerfil = R.drawable.ic_launcher_background }
                        )
                    } else {
                        ProfileScreen(
                            nom, email, dataNaixement, genere, alcada, pes, objectiu, nivellActivitat, fotoPerfil,
                            { editant = true }
                        )
                    }
                }
                AppScreen.WEIGHT -> {
                    WeightTrackingScreen(
                        pesActual = pes,
                        pesObjectiu = pesObjectiu,
                        alcada = alcada
                    )
                }
                AppScreen.ROUTINE -> {
                    RoutineScreen()
                }
            }
        }
    }
}

@Composable
fun RoutineScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Rutina (Pròximament)", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessPreview() {
    AppFitnessIvanOrtegaTheme {
        FitnessApp()
    }
}
