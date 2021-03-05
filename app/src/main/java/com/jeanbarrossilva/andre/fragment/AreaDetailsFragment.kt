package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.jeanbarrossilva.andre.databinding.FragmentAreaDetailsBinding
import com.jeanbarrossilva.andre.fragment.replacement.AndreBottomSheetDialogFragment
import com.jeanbarrossilva.andre.viewmodel.AreaDetailsViewModel
import com.jeanbarrossilva.andre.viewmodel.factory.AndreViewModelFactory.Companion.factoryOf

class AreaDetailsFragment : AndreBottomSheetDialogFragment<FragmentAreaDetailsBinding>(
    { FragmentAreaDetailsBinding.inflate(this) }
) {
    private val viewModel by viewModels<AreaDetailsViewModel> {
        factoryOf<AreaDetailsViewModel>(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.run {
            showDetails()
            configEditingState()
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        viewModel.hideSoftInput()
    }
}