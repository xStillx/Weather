package com.example.weather.features.cities.di

import com.example.weather.features.cities.data.api.CityApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class CityFeaturesModule {
    @Provides
    fun provideCityApi(retrofit: Retrofit) = retrofit.create(
        CityApi::class.java
    )
}
