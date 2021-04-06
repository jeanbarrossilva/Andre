package com.jeanbarrossilva.andre.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jeanbarrossilva.andre.core.BottomSheetOption
import com.jeanbarrossilva.andre.databinding.ViewBottomSheetOptionBinding
import com.jeanbarrossilva.andre.extension.ContextX.layoutInflater
import com.jeanbarrossilva.andre.ui.viewholder.BottomSheetOptionViewHolder

class BottomSheetOptionAdapter(
	private val fragment: BottomSheetDialogFragment,
	private val options: List<BottomSheetOption>
): RecyclerView.Adapter<BottomSheetOptionViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		BottomSheetOptionViewHolder(
			ViewBottomSheetOptionBinding.inflate(parent.context.layoutInflater, parent, false)
		)
	
	override fun onBindViewHolder(holder: BottomSheetOptionViewHolder, position: Int) {
		val option = options[position]
		holder.binding.root.icon = option.icon
		holder.binding.root.text = option.title
		holder.binding.root.setOnClickListener {
			option.action()
			if (option.dismissesDialog)
				fragment.dismiss()
		}
	}
	
	override fun getItemCount() = options.size
}