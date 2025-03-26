package com.example.penziapp.di

import com.example.penziapp.api.ApiService
import com.example.penziapp.api.RetrofitInstance
import com.example.penziapp.data.repository.ChatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide ApiService using RetrofitInstance
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitInstance.apiService
    }

    // Provide ChatRepository with DI
    @Provides
    @Singleton
    fun provideChatRepository(apiService: ApiService): ChatRepository {
        return ChatRepository(apiService)
    }
}
