package com.example.segundaprova.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.segundaprova.db.AppDatabase
import com.example.segundaprova.entity.CityEntity

class AlteraFragmentViewModel(application: Application): AndroidViewModel(application) {
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

  fun AlteraDados(city: CityEntity){
    UpdateCity(city).execute().get()
  }

  @SuppressLint("StaticFieldLeak")
  inner class GetCity(var id: Long): AsyncTask<Unit, Unit, CityEntity>() {
    override fun doInBackground(vararg params: Unit?): CityEntity {
      return database.cityDao().findById(id)
    }
  }

  @SuppressLint("StaticFieldLeak")
  inner class UpdateCity(var city: CityEntity): AsyncTask<Unit, Unit, Unit>() {
    override fun doInBackground(vararg params: Unit?) {
      val city = CityEntity(name, description, population, pib, size, capital)

      database.cityDao().update(city)
    }
  }
}