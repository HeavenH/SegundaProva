package com.example.segundaprova.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity (
  var name: String,
  var description: String,
  var population: Double,
  var pib: Int,
  var capital_city: String,
  var size: String,
) {
  @PrimaryKey(autoGenerate = true)
  var id: Long = 0
}