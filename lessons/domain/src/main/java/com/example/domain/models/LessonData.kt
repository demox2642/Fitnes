package com.example.domain.models

import java.awt.Color

data class LessonData(
    val name: String,
    val place: String,
    val coach: CoachData,
    val color: Color,
    val startTime: String,
    val endTime: String,
    val date: String,
)
