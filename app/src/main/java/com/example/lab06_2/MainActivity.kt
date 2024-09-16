package com.example.lab06_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lab06_2.ui.theme.Lab062Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab062Theme {
                CustomScaffold()  // Usa CustomScaffold para manejar la navegación y el contenido
            }
        }
    }
}


@Composable
fun CustomContent(padding: PaddingValues) {
    // Estado que rastrea el número de clics
    val clickCount = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto que muestra el número de clics
        Text(
            text = "Boton presiona ${clickCount.value} veces",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Botón de acción flotante (FAB)
        CustomFAB(onClick = { clickCount.value++ })
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavHostController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* TODO: Manejar clic en menú */ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /* TODO: Manejar clic en búsqueda */ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            }
            IconButton(onClick = {
                // Navegar a la vista de perfil
                navController.navigate("profile")
            }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            //Icono de estrella
            IconButton(onClick = { navController.navigate("start") }) {
                Icon(Icons.Filled.Star, contentDescription = "Star description")
            }

            IconButton(onClick = { navController.navigate("email") }) {
                Icon(Icons.Filled.Email, contentDescription = "Email description")
            }


            IconButton(onClick = { navController.navigate("phone") }) {
                Icon(Icons.Filled.Phone, contentDescription = "Phone description")
            }

            IconButton(onClick = { navController.navigate("box") }) {
                Icon(Icons.Filled.AccountBox, contentDescription = "Box description")
            }
        }
    }
}
@Composable
fun StartScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centra el contenido dentro del Box
    ) {
        Text(
            text = "Pantalla de Estrella",
            style = TextStyle(
                fontSize = 32.sp, // Tamaño de fuente más grande
                fontWeight = FontWeight.Bold, // Fuente en negrita
                color = MaterialTheme.colorScheme.onBackground // Color del texto
            ),
            textAlign = TextAlign.Center // Centra el texto
        )
    }
}

@Composable
fun EmailScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centra el contenido dentro del Box
    ) {
        Text(
            text = "Pantalla de Email",
            style = TextStyle(
                fontSize = 32.sp, // Tamaño de fuente más grande
                fontWeight = FontWeight.Bold, // Fuente en negrita
                color = MaterialTheme.colorScheme.onBackground // Color del texto
            ),
            textAlign = TextAlign.Center // Centra el texto
        )
    }
}

@Composable
fun PhoneScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centra el contenido dentro del Box
    ) {
        Text(
            text = "Pantalla de Telefono",
            style = TextStyle(
                fontSize = 32.sp, // Tamaño de fuente más grande
                fontWeight = FontWeight.Bold, // Fuente en negrita
                color = MaterialTheme.colorScheme.onBackground // Color del texto
            ),
            textAlign = TextAlign.Center // Centra el texto
        )
    }
}

@Composable
fun BoxScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centra el contenido dentro del Box
    ) {
        Text(
            text = "Pantalla de Box",
            style = TextStyle(
                fontSize = 32.sp, // Tamaño de fuente más grande
                fontWeight = FontWeight.Bold, // Fuente en negrita
                color = MaterialTheme.colorScheme.onBackground // Color del texto
            ),
            textAlign = TextAlign.Center // Centra el texto
        )
    }
}


@Composable
fun CustomFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primary // Color de fondo
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}



@Composable
fun UserProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "User Profile", style = MaterialTheme.typography.titleLarge)
        Icon(
            imageVector = Icons.Outlined.AccountCircle,
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Text(text = "Name: John Doe")
        Text(text = "Email: john.doe@example.com")
    }
}


@Composable
fun CustomScaffold() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { CustomTopBar(navController) },
        bottomBar = { CustomBottomBar(navController) }, // Agrega el bottomBar aquí
        content = { padding ->
            NavHost(
                navController = navController,
                startDestination = "main",
                Modifier.padding(padding)
            ) {
                composable("main") { CustomContent(padding) }
                composable("profile") { UserProfile() }
                composable("start") { StartScreen() }
                composable("email") { EmailScreen() }
                composable("phone") { PhoneScreen() }
                composable("box") { BoxScreen() }
            }
        }
    )
}





