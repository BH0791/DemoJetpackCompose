package com.example.basicstatecodelab

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.ui.theme.DemoJetpackComposeTheme

@Composable
fun TextField() {
    val stringState = remember { mutableStateOf("") }
    TextField(
        value = stringState.value,
        onValueChange = { stringState.value = it }
    )

    println("xxx")
    Text(stringState.value)
}

@Preview
@Composable
private fun TextFieldPreview() {
    DemoJetpackComposeTheme {
        TextField()
    }
}