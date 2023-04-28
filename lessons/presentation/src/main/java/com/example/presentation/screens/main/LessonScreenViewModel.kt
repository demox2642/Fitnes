package com.example.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.LessonData
import com.example.domain.usecase.GetLessonsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonScreenViewModel @Inject constructor(
    private val getLessonsListUseCase: GetLessonsListUseCase,
) : ViewModel() {

    private val _lessonsList = MutableStateFlow(emptyList<LessonData>())
    val lessonsList = _lessonsList.asStateFlow()
    init {
        viewModelScope.launch {
            getLessonsListUseCase.getLessonsList().collectLatest {
                Log.e("LessonScreenViewModel", "lesson = $it")
                _lessonsList.value = it
            }
        }
    }
}
