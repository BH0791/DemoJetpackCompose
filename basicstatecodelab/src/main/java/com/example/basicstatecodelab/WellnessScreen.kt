package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/* Représente l'écran principal et appelez la fonction WaterCounter */
/* ---------------------------------------------------------------- */

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
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
        //val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}

