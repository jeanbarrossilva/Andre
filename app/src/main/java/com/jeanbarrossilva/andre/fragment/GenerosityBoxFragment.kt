package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.andre.databinding.FragmentGenerosityBoxBinding
import com.jeanbarrossilva.andre.fragment.replacement.AndreDialogFragment
import com.jeanbarrossilva.andre.ui.GenerosityBoxButton
import com.jeanbarrossilva.andre.viewmodel.GenerosityBoxViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class GenerosityBoxFragment:
	AndreDialogFragment<FragmentGenerosityBoxBinding>({
		FragmentGenerosityBoxBinding.inflate(this)
	}),
	View.OnClickListener {
	private val viewModel by viewModels<GenerosityBoxViewModel> {
		factoryOf<GenerosityBoxViewModel>(this)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.propagateListener()
	}
	
	override fun onClick(view: View?) {
		if (view is GenerosityBoxButton)
			viewModel.onClick(view)
	}
}