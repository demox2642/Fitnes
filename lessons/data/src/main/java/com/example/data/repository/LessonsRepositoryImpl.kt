package com.example.data.repository

import com.example.data.database.FitnesKitDB
import com.example.data.servises.FitnesKitApi
import com.example.domain.models.LessonData
import com.example.domain.reposirory.LessonsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LessonsRepositoryImpl @Inject constructor(
    private val fitnesKitDB: FitnesKitDB,
    private val fitnesKitApi: FitnesKitApi,
) : LessonsRepository {
    override suspend fun getLessonsList(): Flow<LessonData> {
        TODO("Not yet implemented")
    }
}
