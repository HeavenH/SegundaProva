package com.example.segundaprova.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import com.example.segundaprova.db.AppDatabase
import com.example.segundaprova.entity.CityEntity

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

  val database by lazy { AppDatabase.getDatabase(application) }

  var id: Long = 0
  var name: String = "";
  var description: String = "";
  var population: Double = 0.0;
  var pib: Int = 0;
  var size: String = "";
  var capital: String = "";

  fun createGame() {
    CreateCity().execute().get()
  }

  @SuppressLint("StaticFieldLeak")
  private inner class CreateCity() : AsyncTask<Unit, Unit, Unit>() {
    override fun doInBackground(vararg params: Unit?) {
      val city = CityEntity(name, description, population, pib, size, capital)

      database.cityDao().insert(city)
    }
  }

}