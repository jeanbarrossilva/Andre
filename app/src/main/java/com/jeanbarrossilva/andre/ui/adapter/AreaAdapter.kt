package com.jeanbarrossilva.andre.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.andre.core.Area
import com.jeanbarrossilva.andre.databinding.ViewAreaBinding
import com.jeanbarrossilva.andre.extension.ContextX.layoutInflater
import com.jeanbarrossilva.andre.ui.layoutmanager.UnscrollableLayoutManager
import com.jeanbarrossilva.andre.ui.viewholder.AreaViewHolder

class AreaAdapter(
	private val areas: List<Area>,
	private val onLongClick: (Area) -> Unit
): RecyclerView.Adapter<AreaViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
		AreaViewHolder(ViewAreaBinding.inflate(parent.context.layoutInflater, parent, false))
	
	override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
		val area = areas[position]
		
		holder.binding.root.setOnLongClickListener {
			onLongClick(area)
			true
		}
		holder.binding.colorView.setCardBackgroundColor(area.color)
		holder.binding.titleView.text = area.title
		holder.binding.subareasView.adapter = SubareaAdapter(area.subareas)
		holder.binding.subareasView.layoutManager =
			UnscrollableLayoutManager(holder.itemView.context)
	}
	
	override fun getItemCount() = areas.size
}