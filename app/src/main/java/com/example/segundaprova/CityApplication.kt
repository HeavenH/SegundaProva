package com.example.segundaprova

import android.app.Application
import com.example.segundaprova.db.AppDatabase

class CityApplication : Application() {
  val database by lazy { AppDatabase.getDatabase(this) }
}