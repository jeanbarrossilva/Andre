package com.jeanbarrossilva.andre.fragment

import android.os.Bundle
import android.view.View
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.core.BottomSheetOption
import com.jeanbarrossilva.andre.fragment.replacement.OptionsBottomSheetFragment

class AreaOptionsBottomSheetFragment: OptionsBottomSheetFragment() {
	private var onDelete: () -> Unit = { }
	private var onEdit: () -> Unit = { }
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setOptions(
			listOf(
				BottomSheetOption(
					context,
					R.drawable.ic_edit,
					R.string.AreaOptionsBottomSheetFragment_edit,
					onEdit
				),
				BottomSheetOption(
					context,
					R.drawable.ic_delete,
					R.string.AreaOptionsBottomSheetFragment_delete,
					onDelete
				)
			)
		)
	}
	
	fun setOnEdit(block: () -> Unit) {
		onEdit = block
	}
	
	fun setOnDelete(block: () -> Unit) {
		onDelete = block
	}
}