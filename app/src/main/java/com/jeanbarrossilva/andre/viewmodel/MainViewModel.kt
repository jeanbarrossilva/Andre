package com.jeanbarrossilva.andre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.ui.setupActionBarWithNavController
import com.jeanbarrossilva.andre.activity.MainActivity

@Suppress("StaticFieldLeak")
class MainViewModel(private val activity: MainActivity): ViewModel() {
	fun configNavigation() {
		activity.setSupportActionBar(activity.binding.toolbar)
		activity.setupActionBarWithNavController(activity.navController)
	}
}