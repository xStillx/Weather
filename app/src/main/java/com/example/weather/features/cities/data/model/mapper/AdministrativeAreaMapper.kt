package com.example.weather.features.cities.data.model.mapper

import com.example.weather.features.cities.data.model.AdministrativeAreaRes
import com.example.weather.features.cities.domain.model.AdministrativeArea
import javax.inject.Inject

class AdministrativeAreaMapper @Inject constructor() {

    fun map(administrativeAreaRes: AdministrativeAreaRes) = AdministrativeArea(
        localizedName = administrativeAreaRes.localizedName
    )
}