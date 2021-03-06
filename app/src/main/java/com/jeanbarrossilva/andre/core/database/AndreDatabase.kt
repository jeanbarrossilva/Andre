package com.jeanbarrossilva.andre.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeanbarrossilva.andre.core.database.area.Area
import com.jeanbarrossilva.andre.core.database.area.AreaDao

@Database(entities = [Area::class], version = 1)
abstract class AndreDatabase: RoomDatabase() {
	abstract fun areaDao(): AreaDao
}