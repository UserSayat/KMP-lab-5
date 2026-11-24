package ru.university.lab5navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskListScreen(onTaskClick: (String) -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Задачи") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .padding(padding)
            .fillMaxSize())
        {
            items(TaskRepository.tasks) { task ->
                ListItem(
                    headlineContent = { Text(task.title) },
                    supportingContent = {
                        Text(if (task.isCompleted) "Выполнено" else "В процессе")
                    },
                    modifier = Modifier.clickable {onTaskClick(task.id)}
                )
                HorizontalDivider()
            }
        }
    }
}