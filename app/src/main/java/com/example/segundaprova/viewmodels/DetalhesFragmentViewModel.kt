package com.example.segundaprova.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import com.example.segundaprova.db.AppDatabase
import com.example.segundaprova.entity.CityEntity

class DetalhesFragmentViewModel(application: Application): AndroidViewModel(application) {
  val database by lazy { AppDatabase.getDatabase(application) }

  var id: Long = 0
  var name: String = "";
  var description: String = "";
  var population: Double = 0.0;
  var pib: Int = 0;
  var size: String = "";
  var capital: String = "";

  fun getCity(id: Long) {
    var city = GetCity(id).execute().get()

    this.name = city.name
    this.description = city.description
    this.population = city.population
    this.pib = city.pib
    this.size = city.size
    this.capital = city.capital_city
  }

  @SuppressLint("StaticFieldLeak")
  inner class GetCity(var id: Long): AsyncTask<Unit, Unit, CityEntity>() {
    override fun doInBackground(vararg params: Unit?): CityEntity {
      return database.cityDao().findById(id)
    }
  }
}