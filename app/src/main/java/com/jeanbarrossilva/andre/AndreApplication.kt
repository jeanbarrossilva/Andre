package com.jeanbarrossilva.andre

import android.app.Application
import androidx.room.Room
import com.jeanbarrossilva.andre.core.database.AndreDatabase

class AndreApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		database =
			Room.databaseBuilder(applicationContext, AndreDatabase::class.java, "andre.db").build()
	}
	
	companion object {
		lateinit var database: AndreDatabase
			private set
	}
}