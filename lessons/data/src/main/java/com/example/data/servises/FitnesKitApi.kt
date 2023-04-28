package com.example.data.servises

import com.example.data.models.ServerResponse
import retrofit2.http.GET

interface FitnesKitApi {

    @GET("get_v3/?club_id=2")
    suspend fun getLessonsList(): ServerResponse
}
