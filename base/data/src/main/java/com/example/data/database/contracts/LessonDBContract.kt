package com.example.data.database.contracts

object LessonDBContract {
    const val TABLE_NAME = "lesson"

    object Columns {
        const val APPOINTMENT_ID = "appointment_id"
        const val AVAILABLE_SLOTS = "available_slots"
        const val CLIENT_RECORDED = "client_recorded"
        const val COACH_ID = "coach_id"
        const val COLOR = "color"
        const val COMMERCIAL = "commercial"
        const val DATE = "date"
        const val DESCRIPTION = "description"
        const val ENDTIME = "endTime"
        const val IS_CANCELLED = "is_cancelled"
        const val NAME = "name"
        const val PLACE = "place"
        const val SERVICE_ID = "service_id"
        const val STARTTIME = "startTime"
        const val TAB = "tab"
        const val TAB_ID = "tab_id"
    }
}
