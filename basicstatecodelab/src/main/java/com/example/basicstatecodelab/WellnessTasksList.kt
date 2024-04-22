package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.basicstatecodelab.ui.theme.DemoJetpackComposeTheme

/* ! Pour la liste des tâches et méthode qui génère de fausses données
   ! Notez que dans une application réelle, vous récupérez vos données à partir de votre couche de données.*/
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

/**
 * Fonction composable qui va créer la liste.
 */
@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview(){
    DemoJetpackComposeTheme {
        WellnessTasksList()
    }
}