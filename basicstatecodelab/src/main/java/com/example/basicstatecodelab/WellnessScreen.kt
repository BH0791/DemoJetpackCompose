package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.reactivex.Observable

/* Représente l'écran principal et appelez la fonction WaterCounter */
/* ---------------------------------------------------------------- */

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    Column {
        StatefulCounter()
        WellnessTasksList()
    }
}
