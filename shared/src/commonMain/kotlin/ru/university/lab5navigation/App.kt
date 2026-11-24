package ru.university.lab5navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TaskListRoute) {
        composable<TaskListRoute> {
            TaskListScreen(onTaskClick = { id ->
                navController.navigate(TaskDetailRoute(id))
            })
        }

        composable<TaskDetailRoute> { backStackEntry ->
            val route: TaskDetailRoute = backStackEntry.toRoute()
            TaskDetailScreen(
                taskId = route.taskId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}