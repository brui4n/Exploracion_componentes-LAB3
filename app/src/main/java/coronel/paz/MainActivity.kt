package coronel.paz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coronel.paz.ui.components.EjemploChip
import coronel.paz.ui.components.EjemploConstraintLayout
import coronel.paz.ui.components.EjemploFlowColumnDemo
import coronel.paz.ui.components.EjemploFlowRowDemo
import coronel.paz.ui.components.EjemploLazyGrid
import coronel.paz.ui.components.EjemploLazyRow
import coronel.paz.ui.components.EjemploScaffold
import coronel.paz.ui.components.EjemploSurface
import coronel.paz.ui.components.LazyColumnDemo
import coronel.paz.ui.theme.Exploracion_componentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            // Llamamos al conteneedor con controles
            // LazyColumnDemo()
            // EjemploLazyRow()
            // EjemploLazyGrid()
            // EjemploConstraintLayout()
            // EjemploScaffold()
            // EjemploSurface()
            // EjemploChip()
            // EjemploFlowRowDemo()
            // EjemploFlowColumnDemo()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // LazyColumnDemo()
    // EjemploLazyRow()
    // EjemploLazyGrid()
    // EjemploConstraintLayout()
    // EjemploScaffold()
    // EjemploSurface()
    // EjemploChip()
    // EjemploFlowRowDemo()
    // EjemploFlowColumnDemo()
}