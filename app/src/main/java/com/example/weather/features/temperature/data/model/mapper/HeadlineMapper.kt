package com.example.weather.features.temperature.data.model.mapper

import com.example.weather.features.temperature.data.model.HeadlineRes
import com.example.weather.features.temperature.domain.model.Headline
import javax.inject.Inject

class HeadlineMapper @Inject constructor() {
    fun map(headlineRes: HeadlineRes) = Headline(
        text = headlineRes.text,
        effectiveDate = headlineRes.effectiveDate,
        category = headlineRes.category.orEmpty()
    )
}