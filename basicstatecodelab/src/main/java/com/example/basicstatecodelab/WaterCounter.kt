package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.DemoJetpackComposeTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun WaterCounterAffichage(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {

        var count by remember { mutableStateOf(0) }

        if (count > 0) {

            var showTask by remember { mutableStateOf(true) }

            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Avez-vous fait votre promenade de 15 minutes aujourd'hui ?"
                )
            }
            Text(text = "You've had ${count} glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text("Add one")
            }
            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }
        }
    }

}
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    DemoJetpackComposeTheme {
        WaterCounter()
    }
}