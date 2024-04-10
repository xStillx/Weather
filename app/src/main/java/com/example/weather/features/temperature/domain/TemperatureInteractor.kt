package com.example.weather.features.temperature.domain

import com.example.weather.features.temperature.data.TemperatureRepo
import com.example.weather.utils.safeRequest
import javax.inject.Inject

class TemperatureInteractor @Inject constructor(
    private val temperatureRepo: TemperatureRepo
) {
    suspend fun getDaily(key: String) = safeRequest {
        temperatureRepo.getDaily(key)
    }

    suspend fun getFiveDay(key: String) = safeRequest {
        temperatureRepo.getFiveDay(key)

    }
}
