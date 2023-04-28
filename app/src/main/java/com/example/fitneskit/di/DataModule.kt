package com.example.fitneskit.di // ktlint-disable package-name

import com.example.data.database.FitnesKitDB
import com.example.data.repository.* // ktlint-disable no-wildcard-imports
import com.example.data.servises.FitnesKitApi
import com.example.domain.reposirory.LessonsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideUrl(): String {
        return "https://olimpia.fitnesskit-admin.ru/schedule/"
    }

    @Provides
    @Named("logger")
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
            .apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            }
    }

    @Provides
    fun provideOkHttp(
        @Named("logger") loggingInterceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY),
            )
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit.Builder {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideFitnesKitApi(retrofit: Retrofit.Builder): FitnesKitApi {
        return retrofit.build()
            .create(FitnesKitApi::class.java)
    }

    @Singleton
    @Provides
    fun provideLessonsRepository(fitnesKitDB: FitnesKitDB, fitnesKitApi: FitnesKitApi): LessonsRepository {
        return LessonsRepositoryImpl(fitnesKitDB, fitnesKitApi)
    }
}
