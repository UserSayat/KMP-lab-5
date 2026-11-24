package ru.university.lab5navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskDetailScreen(taskId: String, onBack: () -> Unit) {
    val task = TaskRepository.getTask(taskId)

    Scaffold(
        topBar = { TopAppBar(title = { Text("Детали") }) }
    ) { padding ->
        if (task == null) {
            Box(
               modifier = Modifier
                   .padding(padding)
                   .fillMaxSize(),
               contentAlignment = Alignment.Center
            ) {
                Text("Задача не найдена")
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(task.title, style = MaterialTheme.typography.headlineMedium)
                Text("Статус: ${ if (task.isCompleted) "Выполнено" else "В процессе" }")
                Button(onClick = { TaskRepository.toggleCompleted(taskId) }) {
                    Text(
                        if (task.isCompleted) "Отметить как невыполненную"
                        else "Отметить как выполненную"
                    )
                }
                OutlinedButton(onClick = onBack) {
                    Text("Назад")
                }
            }
        }
    }
}