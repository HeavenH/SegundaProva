package com.example.segundaprova.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.segundaprova.entity.CityEntity

@Dao
interface CityDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(city: CityEntity): Long

  @Delete
  fun delete(city: CityEntity): Int

  @Update
  fun update(city: CityEntity): Int

  @Query("Select * from city")
  fun listAll(): LiveData<List<CityEntity>>

  @Query("Select * FROM city WHERE id = :id")
  fun findById(id: Long): CityEntity
}