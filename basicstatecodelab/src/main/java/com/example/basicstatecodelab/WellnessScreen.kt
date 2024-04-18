package com.example.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/* Représente l'écran principal et appelez la fonction WaterCounter */
/* ---------------------------------------------------------------- */

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    StatefulCounter(modifier)
}
