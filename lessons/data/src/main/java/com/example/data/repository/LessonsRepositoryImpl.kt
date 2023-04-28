package com.example.data.repository

import com.example.data.database.FitnesKitDB
import com.example.data.models.toLessonDB
import com.example.data.models.toLessonData
import com.example.data.models.toTrainerDB
import com.example.data.servises.FitnesKitApi
import com.example.domain.models.LessonData
import com.example.domain.reposirory.LessonsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LessonsRepositoryImpl @Inject constructor(
    private val fitnesKitDB: FitnesKitDB,
    private val fitnesKitApi: FitnesKitApi,
) : LessonsRepository {
    override suspend fun getLessonsList(): Flow<List<LessonData>> = flow {
        val serverResponse = fitnesKitApi.getLessonsList()
        var list = emptyList<LessonData>()
        if (serverResponse.isSuccessful) {
            fitnesKitDB.trainerDAO().insertTrainerList(serverResponse.body()!!.trainers.map { it.toTrainerDB() })
            fitnesKitDB.lessonDAO().insertAnswersList(serverResponse.body()!!.lessons.map { it.toLessonDB() })
            list = fitnesKitDB.lessonDAO().getLessonsList().map { it.toLessonData() }
        }
        emit(list)
    }.flowOn(Dispatchers.IO)
}
