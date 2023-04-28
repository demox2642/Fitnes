package com.example.fitneskit.di // ktlint-disable package-name

import android.content.Context
import androidx.room.Room
import com.example.data.database.FitnesKitDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): FitnesKitDB {
        return Room.databaseBuilder(
            context,
            FitnesKitDB::class.java,
            "fitnes_data_base",
        ).allowMainThreadQueries()
            .build()
    }
}
