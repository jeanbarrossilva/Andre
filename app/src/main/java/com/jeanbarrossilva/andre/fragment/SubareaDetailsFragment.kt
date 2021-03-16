package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.jeanbarrossilva.andre.databinding.FragmentSubareaDetailsBinding
import com.jeanbarrossilva.andre.fragment.replacement.AndreBottomSheetDialogFragment
import com.jeanbarrossilva.andre.viewmodel.SubareaDetailsViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class SubareaDetailsFragment: AndreBottomSheetDialogFragment<FragmentSubareaDetailsBinding>({
	FragmentSubareaDetailsBinding.inflate(this)
}) {
	private val viewModel by viewModels<SubareaDetailsViewModel> {
		factoryOf<SubareaDetailsViewModel>(this)
	}
	private val navArgs by navArgs<SubareaDetailsFragmentArgs>()
	
	val subarea by lazy { navArgs.subarea }
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel.showDetails()
	}
}