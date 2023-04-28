package com.example.data.repository

import com.example.data.servises.FitnesKitApi
import com.example.domain.reposirory.LessonsRepository
import javax.inject.Inject

class LessonsRepositoryImpl @Inject constructor(
    private val fitnesKitApi: FitnesKitApi,
) : LessonsRepository {
    override suspend fun getLessonsList() {
        TODO("Not yet implemented")
    }
}
