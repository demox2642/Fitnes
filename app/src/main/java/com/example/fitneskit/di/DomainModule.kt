package com.example.fitneskit.di // ktlint-disable package-name

import com.example.domain.reposirory.LessonsRepository
import com.example.domain.usecase.* // ktlint-disable no-wildcard-imports
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun providesGetLessonsListUseCase(lessonsRepository: LessonsRepository): GetLessonsListUseCase = GetLessonsListUseCase(lessonsRepository)
}
