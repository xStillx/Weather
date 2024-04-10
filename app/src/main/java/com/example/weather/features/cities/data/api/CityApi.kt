package com.example.weather.features.cities.data.api

import com.example.weather.features.cities.data.model.CityRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CityApi {
    @GET("locations/v1/cities/autocomplete?language=ru-ru")
    suspend fun getSearchList(
        @Query("q") q: String
    ): List<CityRes>

    @GET("locations/v1/topcities/{top}?language=ru-ru")
    suspend fun getTopCities(@Path("top") top: String = "50"): List<CityRes>


}
