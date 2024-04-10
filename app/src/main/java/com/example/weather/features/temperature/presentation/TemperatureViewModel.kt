package com.example.weather.features.temperature.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.features.cities.domain.model.ShortCity
import com.example.weather.features.temperature.domain.TemperatureInteractor
import com.example.weather.features.temperature.domain.model.DailyForecasts
import com.example.weather.features.temperature.domain.model.ShortTemperature
import com.example.weather.utils.ViewState
import com.example.weather.utils.asLiveData
import com.example.weather.utils.asViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemperatureViewModel @Inject constructor(
    private val temperatureInteractor: TemperatureInteractor
) : ViewModel() {

    private val _weatherDaily = MutableLiveData<ViewState<ShortTemperature>>()
    val weatherDaily get() = _weatherDaily.asLiveData()

    private val _isLoading = MutableLiveData(true)
    val isLoading = _isLoading.asLiveData()

    private val _weatherFiveDay = MutableLiveData<ViewState<ShortTemperature>>()
    val weatherFiveDay get() = _weatherFiveDay.asLiveData()

    private val _city = MutableLiveData<ShortCity>()
    val city = _city.asLiveData()

    private val _itemTemperature = MutableLiveData<DailyForecasts>()
    val itemTemperature get() = _itemTemperature.asLiveData()

    private fun getDailyWeather(key: String, indicator: MutableLiveData<Boolean> = _isLoading) {
        indicator.value = true
        viewModelScope.launch {
            val temp = temperatureInteractor.getDaily(key)
            _weatherDaily.value = temp.asViewState()
            indicator.value = false
        }
    }

    private fun getFiveDayWeather(key: String) {
        viewModelScope.launch {
            val temp = temperatureInteractor.getFiveDay(key)
            _weatherFiveDay.value = temp.asViewState()
        }
    }

    fun onArgsReceived(city: ShortCity) {
        _city.value = city
        getDailyWeather(city.key)
        getFiveDayWeather(city.key)
    }

    fun onSelectedItem(itemTemp: DailyForecasts){
        viewModelScope.launch {
            _itemTemperature.value = itemTemp
        }
    }
}
