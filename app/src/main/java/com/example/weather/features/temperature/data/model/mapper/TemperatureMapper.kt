package com.example.weather.features.temperature.data.model.mapper

import com.example.weather.features.temperature.data.model.TemperatureRes
import com.example.weather.features.temperature.domain.model.Temperature
import javax.inject.Inject

class TemperatureMapper @Inject constructor(
    private val minimumMapper: MinimumMapper,
    private val maximumMapper: MaximumMapper
) {
    fun map(temperatureRes: TemperatureRes) = Temperature(
        minimum = temperatureRes.minimum.let { minimumMapper.map(it) },
        maximum = temperatureRes.maximum.let { maximumMapper.map(it) }
    )
}