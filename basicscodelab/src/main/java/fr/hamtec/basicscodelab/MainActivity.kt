package fr.hamtec.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.basicscodelab.ui.theme.DemoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoJetpackComposeTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier : Modifier = Modifier) {
    Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
    ) {
        Greeting(name = "Android")
    }
}

@Composable
fun Greeting(name : String, modifier : Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {


        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                    text = "Hello"
            )
            Text(
                    text = "$name"
            )
        }
    }
}

@Preview(showBackground = true, name = "Premiers pas dans Compose")
@Composable
fun GreetingPreview() {
    DemoJetpackComposeTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, name = "Réutiliser des composables")
@Composable
fun MyAppPrerview() {
    MyApp()
}