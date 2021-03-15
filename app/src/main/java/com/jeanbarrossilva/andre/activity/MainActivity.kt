package com.jeanbarrossilva.andre.activity

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jeanbarrossilva.andre.databinding.ActivityMainBinding
import com.jeanbarrossilva.andre.viewmodel.MainViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class MainActivity: AppCompatActivity() {
	private val viewModel by viewModels<MainViewModel> { factoryOf<MainViewModel>(this) }
	
	lateinit var binding: ActivityMainBinding
		private set
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		viewModel.configBottomNavigation()
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		viewModel.onSelect(item)
		return super.onOptionsItemSelected(item)
	}
	
	override fun onConfigurationChanged(newConfig: Configuration) {
		super.onConfigurationChanged(newConfig)
		viewModel.changeNavBarColorForOrientation()
	}
}