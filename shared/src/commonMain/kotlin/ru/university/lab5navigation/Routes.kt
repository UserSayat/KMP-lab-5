package ru.university.lab5navigation

import kotlinx.serialization.Serializable

@Serializable
object TaskListRoute

@Serializable
data class TaskDetailRoute(val taskId: String)