package com.example.weather.features.temperature.data.model.mapper

import com.example.weather.features.temperature.data.model.DayRes
import com.example.weather.features.temperature.domain.model.Day
import javax.inject.Inject

class DayMapper @Inject constructor() {
    fun map(dayRes: DayRes) = Day(
        iconPhrase = dayRes.iconPhrase,
        precipitationType = dayRes.precipitationType.orEmpty()
    )
}