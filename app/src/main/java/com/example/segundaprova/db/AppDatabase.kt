package com.example.segundaprova.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundaprova.dao.CityDao
import com.example.segundaprova.entity.CityEntity

@Database(entities = [CityEntity::class], version = 1, exportSchema = false)
public abstract class AppDatabase : RoomDatabase() {

  abstract fun cityDao(): CityDao

  companion object {
    // Singleton prevents multiple instances of database opening at the
    // same time.
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
      // if the INSTANCE is not null, then return it,
      // if it is, then create the database
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          AppDatabase::class.java,
          "city"
        )
          .build()
        INSTANCE = instance
        // return instance
        instance
      }
    }
  }
}