package com.jeanbarrossilva.andre.core.database.area

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface AreaDao {
	@Query("SELECT * FROM areas")
	fun getAll(): LiveData<List<Area>>
}