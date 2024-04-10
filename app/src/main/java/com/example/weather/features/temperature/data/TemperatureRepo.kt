package com.example.weather.features.temperature.data

import com.example.weather.features.temperature.data.api.TemperatureApi
import com.example.weather.features.temperature.data.model.mapper.TemperaturesMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TemperatureRepo @Inject constructor(
    private val temperatureApi: TemperatureApi,
    private val temperaturesMapper: TemperaturesMapper
) {
    suspend fun getDaily(key: String) = withContext(Dispatchers.IO) {
        temperatureApi.getDaily(key).let { res -> temperaturesMapper.map(res) }
    }

    suspend fun getFiveDay(key: String) = withContext(Dispatchers.IO) {
        temperatureApi.getFiveDay(key).let { res -> temperaturesMapper.map(res) }
    }

}
