package com.jeanbarrossilva.andre.viewmodel

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.navigation.ui.setupActionBarWithNavController
import com.jeanbarrossilva.andre.activity.MainActivity
import com.jeanbarrossilva.andre.extension.ActivityX.toolbar
import com.jeanbarrossilva.andre.extension.AppCompatActivityX.findNavController

@Suppress("StaticFieldLeak")
class MainViewModel(private val activity: MainActivity): ViewModel() {
	fun configToolbar() {
		activity.setSupportActionBar(activity.toolbar)
		activity.setupActionBarWithNavController(activity.findNavController()!!)
	}
	
	fun onSelect(item: MenuItem) {
		if (item.itemId == android.R.id.home)
			activity.onBackPressed()
	}
}