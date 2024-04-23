package com.example.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel


class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    /**
     * reçoit une tâche à modifier avec une nouvelle valeur pour l'état coché.
     */
    fun changeTaskChecked(
        item: WellnessTask,
        checked: Boolean
    ) =
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

}

/* ! Pour la liste des tâches et méthode qui génère de fausses données
   ! Notez que dans une application réelle, vous récupérez vos données à partir de votre couche de données.*/
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }