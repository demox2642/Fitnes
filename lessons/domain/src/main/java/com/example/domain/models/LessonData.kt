package com.example.domain.models

data class LessonData(
    val name: String,
    val place: String,
    val coach: CoachData?,
    val color: String,
    val startTime: String,
    val endTime: String,
    val date: String,
)
