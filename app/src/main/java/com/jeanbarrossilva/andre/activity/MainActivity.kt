package com.jeanbarrossilva.andre.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.viewmodel.MainViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class MainActivity: AppCompatActivity() {
	private val viewModel by viewModels<MainViewModel> { factoryOf<MainViewModel>(this) }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		viewModel.configToolbar()
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		viewModel.onSelect(item)
		return super.onOptionsItemSelected(item)
	}
}