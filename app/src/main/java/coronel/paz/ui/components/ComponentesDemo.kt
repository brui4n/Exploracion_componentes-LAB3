package coronel.paz.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import coronel.paz.R
import kotlinx.coroutines.launch
import androidx.compose.foundation.pager.*
import androidx.compose.material.*
import androidx.compose.material3.TopAppBar

@Composable
fun LazyColumnDemo() {
    // Datos de ejemplo
    val itemsList = listOf("Elemento 1", "Elemento 2", "Elemento 3")

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(itemsList) { item ->
            Card( // Card  (para agrupar cada ítem con estilo)
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Texto
                    Text(text = item, style = MaterialTheme.typography.titleMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    // Imagen
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Imagen de prueba",
                        modifier = Modifier.size(64.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Checkbox (Boton donde se puede marcar como casilla de verificacion)
                    var checked by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )

                    // RadioButton (Boton redondo)
                    var selected by remember { mutableStateOf(false) }
                    RadioButton(
                        selected = selected,
                        onClick = { selected = !selected }
                    )

                    // Slider (barra deslizante que se puede mover de izquierda
                    // a derecha para escoger un valor)
                    var sliderValue by remember { mutableStateOf(0f) }
                    Slider(
                        value = sliderValue,
                        onValueChange = { sliderValue = it },
                        valueRange = 0f..10f
                    )
                }
            }
        }
    }
}

@Composable
fun EjemploLazyRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Switch( // (interruptor ON/OFF)
                checked = false,
                onCheckedChange = {}
            )
        }
        item {
            LinearProgressIndicator( // (barra de progreso horizontal)
                progress = 0.5f,
                modifier = Modifier.width(100.dp)
            )
        }
        item {
            CircularProgressIndicator( // (barra de progreso circular)
                progress = 0.7f,
                modifier = Modifier.size(50.dp)
            )
        }
        item {
            OutlinedTextField( // (campo de texto con borde)
                value = "Hola",
                onValueChange = {}
            )
        }
        item {
            Divider( // (línea separadora)
                modifier = Modifier
                    .height(40.dp)
                    .width(1.dp)
            )
        }
    }
}

@Composable
fun EjemploLazyGrid() {
    val items = listOf("Uno", "Dos", "Tres", "Cuatro")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items.size) { index ->
            when (index) {
                0 -> {
                    FloatingActionButton( // (botón flotante circular)
                        onClick = {}
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = "FAB")
                    }
                }
                1 -> {
                    var expanded by remember { mutableStateOf(false) }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        TextButton(onClick = { expanded = true }) {
                            Text("Abrir menú")
                        }
                        DropdownMenu( // (menú desplegable)
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Opción 1") },
                                onClick = { expanded = false }
                            )
                            DropdownMenuItem(
                                text = { Text("Opción 2") },
                                onClick = { expanded = false }
                            )
                        }
                    }
                }
                2 -> {
                    // SnackBar (mensaje emergente en la parte inferior)
                    val snackbarHostState = remember { SnackbarHostState() }
                    val scope = rememberCoroutineScope()

                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Button(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Hola desde SnackBar")
                            }
                        }) {
                            Text("Mostrar SnackBar")
                        }
                    }

                    SnackbarHost(
                        hostState = snackbarHostState
                    )
                }
                3 -> {
                    // TabRow (barra de pestañas)
                    var selectedTab by remember { mutableStateOf(0) }
                    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

                    TabRow(
                        selectedTabIndex = selectedTab
                    ) {
                        tabs.forEachIndexed { i, text ->
                            Tab(
                                selected = selectedTab == i,
                                onClick = { selectedTab = i },
                                text = { Text(text) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // Creamos referencias para cada vista
        val (topBar, navRail, boton) = createRefs()


        TopAppBar( // Barra superior
            title = { Text("ConstraintLayout Demo") },
            modifier = Modifier
                .height(56.dp) // altura estándar
                .constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


        NavigationRail( // Barra lateral
            modifier = Modifier.constrainAs(navRail) {
                top.linkTo(topBar.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorito") }
            )
        }

        // Botón que abre un AlertDialog
        var showDialog by remember { mutableStateOf(false) }

        Button(
            onClick = { showDialog = true },
            modifier = Modifier.constrainAs(boton) {
                top.linkTo(topBar.bottom, margin = 100.dp)
                start.linkTo(navRail.end, margin = 16.dp)
            }
        ) {
            Text("Mostrar diálogo")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título") },
                text = { Text("Este es un AlertDialog en ConstraintLayout.") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Demo Scaffold") }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    "Barra inferior",
                    modifier = Modifier.padding(16.dp)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción */ }) {
                Icon(Icons.Default.Favorite, contentDescription = "FAB")
            }
        }
    ) { innerPadding ->
        // Contenido principal
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Hola desde el Scaffold")
            Button(onClick = {}) {
                Text("Click")
            }
        }
    }
}

@Composable
fun EjemploSurface() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        tonalElevation = 4.dp,
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Icono favorito",
                tint = MaterialTheme.colorScheme.primary
            )
            Text("Este es un Surface")
            Button(onClick = {}) {
                Text("Acción")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploChip() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Chip (pequeño botón estilizado con ícono o texto)
        AssistChip(
            onClick = { showDialog = true },
            label = { Text("Abrir diálogo") },
            leadingIcon = {
                Icon(Icons.Default.Favorite, contentDescription = "Icono")
            }
        )

        // Dialog (ventana emergente sencilla)
        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 6.dp
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Este es un Dialog")
                        Spacer(Modifier.height(12.dp))
                        Button(onClick = { showDialog = false }) {
                            Text("Cerrar")
                        }
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowRowDemo() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Reutilizamos controles simples
        Button(onClick = { }) {
            Text("Botón 1")
        }
        Button(onClick = { }) {
            Text("Botón 2")
        }
        Button(onClick = { }) {
            Text("Botón 3")
        }
        Button(onClick = { }) {
            Text("Botón 4")
        }
        Button(onClick = { }) {
            Text("Botón 5")
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EjemploFlowColumnDemo() {
    FlowColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Reutilizamos controles simples
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.4f)) {
            Text("Card 1", modifier = Modifier.padding(8.dp))
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.4f)) {
            Text("Card 2", modifier = Modifier.padding(8.dp))
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.4f)) {
            Text("Card 3", modifier = Modifier.padding(8.dp))
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.4f)) {
            Text("Card 4", modifier = Modifier.padding(8.dp))
        }
        ElevatedCard(modifier = Modifier.fillMaxWidth(0.4f)) {
            Text("Card 5", modifier = Modifier.padding(8.dp))
        }
    }
}




