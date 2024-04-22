package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.basicstatecodelab.ui.theme.DemoJetpackComposeTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun WaterCounterAffichage(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {

        var count by remember { mutableStateOf(0) }

        if (count > 0) {

            var showTask by remember { mutableStateOf(true) }

            if (showTask) {
                WellnessTaskItem(
                    taskName = "Avez-vous fait votre promenade de 15 minutes aujourd'hui ?",
                    checked = false,
                    onCheckedChange = { /*TODO*/ },
                    onClose = { /*TODO*/ })
            }
            Text(text = "You've had ${count} glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)
            ) {





                Text("Clear water count")
            }
        }
    }

}


@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {

            Text("Add one")
        }
    }
}
@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    //var juiceCount by rememberSaveable { mutableStateOf(0) }
Row {
    StatelessCounter(count , {count++}, modifier)
    //StatelessCounter(juiceCount, { juiceCount++ }, modifier)
}

}
@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    DemoJetpackComposeTheme {
        StatelessCounter(0, {})
    }
}
//@PreviewScreenSizes
//@PreviewFontScale
@PreviewLightDark
@Preview(showBackground = true, name = "StatelessCounter", locale = "fr-rFR", backgroundColor = 0xFF75FFEE)
@Composable
fun StatelessCounterPreview(){
    DemoJetpackComposeTheme {
        StatelessCounter(0,{})
    }
}