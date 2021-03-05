package com.jeanbarrossilva.andre.fragment

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.andre.databinding.FragmentAreasBinding
import com.jeanbarrossilva.andre.fragment.replacement.BindingFragment
import com.jeanbarrossilva.andre.viewmodel.AreasViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class AreasFragment: BindingFragment<FragmentAreasBinding>({ FragmentAreasBinding.inflate(this) }) {
	private val viewModel by viewModels<AreasViewModel> { factoryOf<AreasViewModel>(this) }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewModel.showMenu()
	}
	
	override fun onAttach(context: Context) {
		super.onAttach(context)
		viewModel.waitForNewArea()
	}
	
	override fun onResume() {
		super.onResume()
		viewModel.run {
			configSystemBars()
			configFab()
			showAreas()
		}
	}
	
	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		viewModel.configMenu(menu, inflater)
	}
}