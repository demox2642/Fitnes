package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.LessonDBDAO
import com.example.data.database.dao.TrainerDBDAO
import com.example.data.database.models.LessonDB
import com.example.data.database.models.TrainerDB

@Database(
    entities = [
        LessonDB::class,
        TrainerDB::class,

    ],
    version = 1,
)
abstract class FitnesKitDB : RoomDatabase() {
    abstract fun lessonDAO(): LessonDBDAO
    abstract fun trainerDAO(): TrainerDBDAO
}
