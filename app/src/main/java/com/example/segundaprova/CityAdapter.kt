package com.example.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.entity.CityEntity

class CityAdapter : RecyclerView.Adapter<CityViewHolder>() {

  var cities: List<CityEntity> = ArrayList()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
    var v = LayoutInflater.from(parent.context).inflate(R.layout.city_inflater, parent, false)

    return CityViewHolder(v)
  }

  override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
    val pickCity = cities.get(position)
    holder.nomeCity.text = pickCity.name
  }

  override fun getItemCount(): Int {
    return cities .size
  }
}

class CityViewHolder(v: View) : RecyclerView.ViewHolder(v) {
  val nomeCity = v.findViewById<TextView>(R.id.cityName)
}
