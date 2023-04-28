package com.example.domain.usecase

import com.example.domain.reposirory.LessonsRepository

class GetLessonsListUseCase(private val lessonsRepository: LessonsRepository) {
    suspend fun getLessonsList() = lessonsRepository.getLessonsList()
}
