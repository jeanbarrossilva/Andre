package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.andre.databinding.FragmentSubareasBinding
import com.jeanbarrossilva.andre.fragment.replacement.BindingFragment
import com.jeanbarrossilva.andre.viewmodel.SubareasViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class SubareasFragment:
	BindingFragment<FragmentSubareasBinding>({ FragmentSubareasBinding.inflate(this) }) {
	private val viewModel by viewModels<SubareasViewModel> { factoryOf<SubareasViewModel>(this) }
	private val navArgs by navArgs<SubareasFragmentArgs>()
	
	internal val area by lazy { navArgs.area }
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.run {
			configSubareasForDebugging()
			showSubareasInChart()
		}
	}
}