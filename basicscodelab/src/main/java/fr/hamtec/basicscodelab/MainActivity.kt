package fr.hamtec.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

/* ++++++++++++++++++++++++++++++++++++++++++
   ++          TP-Jetpack_Compose          ++
   ++++++++++++++++++++++++++++++++++++++++++
 */
@Composable
fun MyApp(modifier : Modifier = Modifier) {
    //- Souvenir souvenir bla bla... [rememberSaveable]
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
private fun Greetings(
        modifier : Modifier = Modifier,
        names : List<String> = List(1000){"$it"}    //- Liste de noms
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items (items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name : String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                    modifier = Modifier
                            .weight(1f)
                            .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(
                    onClick = { expanded = ! expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun OnboardingScreen(
        onContinueClicked : () -> Unit,
        modifier : Modifier = Modifier
) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

// ** ------------------------------------------------------------------------------------ Preview -

@Preview(showBackground = true, name = "Hisser un état", widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    DemoJetpackComposeTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview(showBackground = true, name = "Premiers pas dans Compose", widthDp = 320)
@Composable
fun GreetingsPreview() {
    DemoJetpackComposeTheme {
        Greetings()
    }
}

@Preview(name = "Réutiliser des composables")
@Composable
fun MyAppPreview() {
    DemoJetpackComposeTheme {
        MyApp(Modifier.fillMaxSize())
    }
}