package com.jeanbarrossilva.andre.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.andre.core.Subarea
import com.jeanbarrossilva.andre.databinding.ViewSubareaBinding
import com.jeanbarrossilva.andre.extension.ContextX.layoutInflater
import com.jeanbarrossilva.andre.ui.viewholder.SubareaViewHolder

class SubareaAdapter(private val subareas: List<Subarea>):
	RecyclerView.Adapter<SubareaViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		SubareaViewHolder(ViewSubareaBinding.inflate(parent.context.layoutInflater, parent, false))
	
	override fun onBindViewHolder(holder: SubareaViewHolder, position: Int) {
		val subarea = subareas[position]
		
		holder.binding.titleView.text = subarea.title
		holder.binding.indicatorView.subarea = subarea
		holder.binding.indicatorTitleView.text = subarea.indicator.title
	}
	
	override fun getItemCount() = subareas.size
}