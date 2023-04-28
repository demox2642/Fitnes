package com.example.data.database.models

import androidx.room.Embedded
import androidx.room.Relation
import com.example.data.database.contracts.LessonDBContract
import com.example.data.database.contracts.TrainerDBContract

data class LessonWithTrainerDB(
    @Embedded
    val lesson: LessonDB,
    @Relation(
        parentColumn = LessonDBContract.Columns.COACH_ID,
        entityColumn = TrainerDBContract.Columns.ID,
    )
    val trainer: TrainerDB? = null,
)
