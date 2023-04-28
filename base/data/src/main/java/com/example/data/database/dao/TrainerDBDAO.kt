package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.data.database.models.TrainerDB

@Dao
interface TrainerDBDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrainerList(trainerList: List<TrainerDB>)

    @Delete
    fun deleteTrainer(trainerDB: TrainerDB)
}
