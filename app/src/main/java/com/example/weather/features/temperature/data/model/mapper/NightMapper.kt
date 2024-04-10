package com.example.weather.features.temperature.data.model.mapper

import com.example.weather.features.temperature.data.model.NightRes
import com.example.weather.features.temperature.domain.model.Night
import javax.inject.Inject

class NightMapper @Inject constructor() {
    fun map(nightRes: NightRes) = Night(
        iconPhrase = nightRes.iconPhrase
    )
}