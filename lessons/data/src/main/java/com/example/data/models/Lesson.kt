package com.example.data.models

import com.example.data.database.models.LessonDB
import com.example.data.database.models.LessonWithTrainerDB
import com.example.domain.models.LessonData

data class Lesson(
    val appointment_id: String,
    val available_slots: Int,
    val client_recorded: Boolean,
    val coach_id: String,
    val color: String,
    val commercial: Boolean,
    val date: String,
    val description: String,
    val endTime: String,
    val is_cancelled: Boolean,
    val name: String,
    val place: String,
    val service_id: String,
    val startTime: String,
    val tab: String,
    val tab_id: Int,
)

fun Lesson.toLessonDB(): LessonDB {
    return LessonDB(
        this.appointment_id,
        this.available_slots,
        this.client_recorded,
        this.coach_id,
        this.color,
        this.commercial,
        this.date,
        this.description,
        this.endTime,
        this.is_cancelled,
        this.name,
        this.place,
        this.service_id,
        this.startTime,
        this.tab,
        this.tab_id,
    )
}

fun LessonWithTrainerDB.toLessonData(): LessonData {
    return LessonData(
        name = this.lesson.name_lesson.toString(),
        place = this.lesson.place,
        coach = this.trainer?.toCoachData(),
        color = this.lesson.color,
        startTime = this.lesson.startTime,
        endTime = this.lesson.endTime,
        date = this.lesson.date,
    )
}
