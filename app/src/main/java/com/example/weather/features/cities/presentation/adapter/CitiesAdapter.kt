package com.example.weather.features.cities.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weather.R
import com.example.weather.databinding.TopCitiesItemBinding
import com.example.weather.features.cities.domain.model.ShortCity

class CitiesAdapter(
    private val cities: List<ShortCity>,
    private val onCityClick: (city: ShortCity) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CitiesViewHolder {
        val cellForCity =
            LayoutInflater.from(parent.context).inflate(R.layout.top_cities_item, parent, false)
        return CitiesViewHolder(cellForCity)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(cities[position])
        holder.itemView.setOnClickListener {
            onCityClick.invoke(cities[position])
        }
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class CitiesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewBinding: TopCitiesItemBinding by viewBinding(TopCitiesItemBinding::bind)

        fun bind(city: ShortCity) {
            viewBinding.city.text = city.localizedName
            viewBinding.country.text = city.country.localizedName
        }
    }
}