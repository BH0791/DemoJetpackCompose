package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.ui.theme.DemoJetpackComposeTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count = 0
        Text(text = "You've had $count glasses.")
        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Add one")
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