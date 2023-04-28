package com.example.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.database.contracts.LessonDBContract

@Entity(
    tableName = LessonDBContract.TABLE_NAME,

)
data class LessonDB(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = LessonDBContract.Columns.APPOINTMENT_ID)
    val appointment_id: String,
    @ColumnInfo(name = LessonDBContract.Columns.AVAILABLE_SLOTS)
    val available_slots: Int,
    @ColumnInfo(name = LessonDBContract.Columns.CLIENT_RECORDED)
    val client_recorded: Boolean,
    @ColumnInfo(name = LessonDBContract.Columns.COACH_ID)
    val coach_id: String? = "",
    @ColumnInfo(name = LessonDBContract.Columns.COLOR)
    val color: String,
    @ColumnInfo(name = LessonDBContract.Columns.COMMERCIAL)
    val commercial: Boolean,
    @ColumnInfo(name = LessonDBContract.Columns.DATE)
    val date: String,
    @ColumnInfo(name = LessonDBContract.Columns.DESCRIPTION)
    val description: String?,
    @ColumnInfo(name = LessonDBContract.Columns.ENDTIME)
    val endTime: String,
    @ColumnInfo(name = LessonDBContract.Columns.IS_CANCELLED)
    val is_cancelled: Boolean,
    @ColumnInfo(name = LessonDBContract.Columns.NAME)
    val name_lesson: String?,
    @ColumnInfo(name = LessonDBContract.Columns.PLACE)
    val place: String,
    @ColumnInfo(name = LessonDBContract.Columns.SERVICE_ID)
    val service_id: String,
    @ColumnInfo(name = LessonDBContract.Columns.STARTTIME)
    val startTime: String,
    @ColumnInfo(name = LessonDBContract.Columns.TAB)
    val tab: String,
    @ColumnInfo(name = LessonDBContract.Columns.TAB_ID)
    val tab_id: Int,
)
