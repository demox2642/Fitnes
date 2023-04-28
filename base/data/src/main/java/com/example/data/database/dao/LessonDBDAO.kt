package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.contracts.LessonDBContract
import com.example.data.database.models.LessonDB
import com.example.data.database.models.LessonWithTrainerDB

@Dao
interface LessonDBDAO {

    @Query("SELECT * FROM ${LessonDBContract.TABLE_NAME}")
    fun getLessonsList(): List<LessonWithTrainerDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswersList(lessonsList: List<LessonDB>)

    @Delete
    fun deleteAnswers(lessonDB: LessonDB)
}
