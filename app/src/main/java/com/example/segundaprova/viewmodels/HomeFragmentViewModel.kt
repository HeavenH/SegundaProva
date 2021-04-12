package com.example.segundaprova.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.segundaprova.db.AppDatabase
import com.example.segundaprova.entity.CityEntity

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {

  val database by lazy { AppDatabase.getDatabase(application) }

  var list: LiveData<List<CityEntity>>

  init {
    list = ListCities().execute().get()
  }

  @SuppressLint("StaticFieldLeak")
  inner class ListCities(): AsyncTask<Int, Int, LiveData<List<CityEntity>>>() {
    override fun doInBackground(vararg params: Int?): LiveData<List<CityEntity>> {
      return database.cityDao().listAll()
    }
  }
}