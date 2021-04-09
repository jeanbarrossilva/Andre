package com.jeanbarrossilva.andre.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.databinding.ActivityMainBinding
import com.jeanbarrossilva.andre.viewmodel.MainViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class MainActivity: AppCompatActivity() {
	private val viewModel by viewModels<MainViewModel> { factoryOf<MainViewModel>(this) }
	
	internal val navController by lazy { findNavController(R.id.container) }
	
	lateinit var binding: ActivityMainBinding
		private set
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		viewModel.configNavigation()
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home)
			onBackPressed()
		return super.onOptionsItemSelected(item)
	}
}