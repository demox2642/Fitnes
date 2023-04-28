package com.example.domain.reposirory

import com.example.domain.models.LessonData
import kotlinx.coroutines.flow.Flow

interface LessonsRepository {
    suspend fun getLessonsList(): Flow<List<LessonData>>
}
