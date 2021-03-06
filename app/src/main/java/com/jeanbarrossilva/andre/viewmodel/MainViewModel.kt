package com.jeanbarrossilva.andre.viewmodel

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.jeanbarrossilva.andre.activity.MainActivity
import com.jeanbarrossilva.andre.extension.ActivityX.toolbar
import com.jeanbarrossilva.andre.extension.AppCompatActivityX.findNavController
import com.jeanbarrossilva.andre.extension.ContextX.onFirstRun
import com.jeanbarrossilva.andre.worker.DefaultAreasWorker

@Suppress("StaticFieldLeak")
class MainViewModel(private val activity: MainActivity): ViewModel() {
	fun configToolbar() {
		activity.setSupportActionBar(activity.toolbar)
		activity.setupActionBarWithNavController(activity.findNavController()!!)
	}
	
	fun checkForDefaultAreasPresence() =
		activity.onFirstRun {
			val request = OneTimeWorkRequest.from(DefaultAreasWorker::class.java)
			WorkManager.getInstance(activity).enqueue(request)
		}
	
	fun onSelect(item: MenuItem) {
		if (item.itemId == android.R.id.home)
			activity.onBackPressed()
	}
}