package com.jeanbarrossilva.andre.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.jeanbarrossilva.andre.core.database.area.Area
import com.jeanbarrossilva.andre.repository.AreaRepository
import kotlinx.coroutines.launch

class DefaultAreasWorker(context: Context, params: WorkerParameters): Worker(context, params) {
	override fun doWork(): Result {
		AreaRepository.scope.launch {
			val defaultAreas = Area.getDefault(applicationContext)
			val areas = AreaRepository.getAreasAsync().await().value.orEmpty()
			
			if (!areas.containsAll(defaultAreas)) {
				val absentAreas = defaultAreas.filter { it !in areas }.toTypedArray()
				AreaRepository.addAsync(*absentAreas).await()
			}
		}
		
		return Result.success()
	}
}