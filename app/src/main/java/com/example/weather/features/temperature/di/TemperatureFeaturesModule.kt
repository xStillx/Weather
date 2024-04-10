package com.example.weather.features.temperature.di

import com.example.weather.features.temperature.data.api.TemperatureApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class TemperatureFeaturesModule {
    @Provides
    fun provideTemperatureApi(retrofit: Retrofit) = retrofit.create(
        TemperatureApi::class.java
    )
}
