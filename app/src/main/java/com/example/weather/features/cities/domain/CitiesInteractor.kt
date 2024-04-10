package com.example.weather.features.cities.domain

import com.example.weather.features.cities.data.CityRepo
import com.example.weather.utils.safeRequest
import javax.inject.Inject

class CitiesInteractor @Inject constructor(
    private val cityRepo: CityRepo
) {
    suspend fun getCity() = safeRequest {
        cityRepo.getTop50Cities()
    }

    suspend fun getSearchList(query: String) = safeRequest {
        cityRepo.getSearchList(query)
    }
}