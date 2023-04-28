package com.example.data.models

data class ServerResponse(
    val lessons: List<Lesson>,
    val option: Option,
    val tabs: List<Tab>,
    val trainers: List<Trainer>,
)
