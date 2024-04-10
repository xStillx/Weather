package com.example.weather.features.temperature.data.model.mapper

import com.example.weather.features.temperature.data.model.MinimumRes
import com.example.weather.features.temperature.domain.model.Minimum
import javax.inject.Inject

class MinimumMapper @Inject constructor() {
    fun map(minimumRes: MinimumRes) = Minimum(
        value = minimumRes.value,
        unit = minimumRes.unit
    )
}