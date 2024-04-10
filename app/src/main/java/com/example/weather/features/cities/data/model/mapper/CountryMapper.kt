package com.example.weather.features.cities.data.model.mapper

import com.example.weather.features.cities.data.model.CountryRes
import com.example.weather.features.cities.domain.model.Country
import javax.inject.Inject

class CountryMapper @Inject constructor() {
    fun map(countryRes: CountryRes) = Country(
        localizedName = countryRes.localizedName
    )
}