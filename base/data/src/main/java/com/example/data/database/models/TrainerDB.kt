package com.example.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.database.contracts.TrainerDBContract

@Entity(
    tableName = TrainerDBContract.TABLE_NAME,
)
data class TrainerDB(
    @ColumnInfo(name = TrainerDBContract.Columns.DESCRIPTION)
    val description: String,
    @ColumnInfo(name = TrainerDBContract.Columns.FULL_NAME)
    val full_name: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = TrainerDBContract.Columns.ID)
    val id: String,
    @ColumnInfo(name = TrainerDBContract.Columns.IMAGE_URL)
    val image_url: String,
    @ColumnInfo(name = TrainerDBContract.Columns.IMAGE_URL_MEDIUM)
    val image_url_medium: String,
    @ColumnInfo(name = TrainerDBContract.Columns.IMAGE_URL_SMALL)
    val image_url_small: String,
    @ColumnInfo(name = TrainerDBContract.Columns.LAST_NAME)
    val last_name: String,
    @ColumnInfo(name = TrainerDBContract.Columns.NAME)
    val name: String,
    @ColumnInfo(name = TrainerDBContract.Columns.POSITION)
    val position: String,
)
