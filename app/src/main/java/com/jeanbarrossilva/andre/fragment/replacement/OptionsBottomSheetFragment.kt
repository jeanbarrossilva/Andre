package com.jeanbarrossilva.andre.fragment.replacement

import android.os.Bundle
import android.view.View
import com.jeanbarrossilva.andre.core.BottomSheetOption
import com.jeanbarrossilva.andre.databinding.FragmentBottomSheetOptionsBinding
import com.jeanbarrossilva.andre.ui.adapter.BottomSheetOptionAdapter
import com.jeanbarrossilva.andre.ui.layoutmanager.UnscrollableLayoutManager

open class OptionsBottomSheetFragment:
	AndreBottomSheetDialogFragment<FragmentBottomSheetOptionsBinding>({ inflater, container ->
		FragmentBottomSheetOptionsBinding.inflate(inflater, container, false)
	}) {
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.root.layoutManager = UnscrollableLayoutManager(context)
	}
	
	fun setOptions(options: List<BottomSheetOption>) {
		binding.root.adapter = BottomSheetOptionAdapter(fragment = this, options)
	}
}