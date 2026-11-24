package ru.university.lab5navigation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform