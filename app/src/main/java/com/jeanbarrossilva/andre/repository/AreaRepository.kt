package com.jeanbarrossilva.andre.repository

import com.jeanbarrossilva.andre.AndreApplication
import com.jeanbarrossilva.andre.core.database.area.Area
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

object AreaRepository {
	val scope = CoroutineScope(Dispatchers.Default)
	
	fun getAreasAsync() =
		scope.async { AndreApplication.database.areaDao().getAll() }
	
	fun addAsync(vararg areas: Area) =
		scope.async { AndreApplication.database.areaDao().add(*areas) }
}