package com.example.data.models

import com.example.data.database.models.TrainerDB
import com.example.domain.models.CoachData

data class Trainer(
    val description: String,
    val full_name: String,
    val id: String,
    val image_url: String,
    val image_url_medium: String,
    val image_url_small: String,
    val last_name: String,
    val name: String,
    val position: String,
)
fun Trainer.toTrainerDB(): TrainerDB {
    return TrainerDB(
        this.description,
        this.full_name,
        this.id,
        this.image_url,
        this.image_url_medium,
        this.image_url_small,
        this.last_name,
        this.name,
        this.position,
    )
}

fun TrainerDB.toCoachData(): CoachData {
    return CoachData(this.id, this.last_name + this.name)
}
