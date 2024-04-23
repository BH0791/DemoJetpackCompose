package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

/* Représente l'écran principal et appelez la fonction WaterCounter */
/* ---------------------------------------------------------------- */

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column {
        StatefulCounter()
        /*
         * La fonction mutableStateOf renvoie un objet de type MutableState<T>.
         * Les fonctions mutableStateListOf et toMutableStateList renvoient un objet de type SnapshotStateList<T>.
         * Dans cette section, les termes "MutableList observable" font référence à cette classe.
         * https://developer.android.com/reference/kotlin/androidx/compose/runtime/snapshots/SnapshotStateList
         --  toMutableStateList()
          ! Créer une instance de [MutableList]<T> à partir d'une collection qui est observable et peut être instantanée.
         */
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

/* ! Pour la liste des tâches et méthode qui génère de fausses données
   ! Notez que dans une application réelle, vous récupérez vos données à partir de votre couche de données.*/
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
