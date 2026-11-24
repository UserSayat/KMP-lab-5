package ru.university.lab5navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class Task(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false
)

object TaskRepository {
    val tasks: SnapshotStateList<Task> = mutableStateListOf(
        Task("1", "Купить молоко"),
        Task("1", "Сделать уроки"),
        Task("1", "Позвонить маме")
    )

    fun getTask(id: String): Task? = tasks.find { it.id == id }

    fun toggleCompleted(id: String) {
        val index = tasks.indexOfFirst { it.id == id }
        if (index != -1) {
            val task = tasks[index]
            tasks[index] = task.copy(isCompleted = !task.isCompleted)
        }
    }

}