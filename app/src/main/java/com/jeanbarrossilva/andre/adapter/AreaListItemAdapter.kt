package com.jeanbarrossilva.andre.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.andre.R
import com.jeanbarrossilva.andre.adapter.viewholder.AreaListItemViewHolder
import com.jeanbarrossilva.andre.core.database.area.Area
import com.jeanbarrossilva.andre.databinding.ViewAreaListItemBinding

class AreaListItemAdapter(
	private val areas: List<Area>,
	private val showsPercentage: Boolean = false,
	private val onAreaClick: (Area) -> Unit = { },
	private val onAreaHold: (Area) -> Unit = { }
): RecyclerView.Adapter<AreaListItemViewHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaListItemViewHolder {
		val view =
			LayoutInflater.from(parent.context).inflate(R.layout.view_area_list_item, parent, false)
		return AreaListItemViewHolder(ViewAreaListItemBinding.bind(view))
	}
	
	override fun onBindViewHolder(holder: AreaListItemViewHolder, position: Int) {
		areas[position].let { area ->
			holder.nameView.text = area.name
			holder.iconView.setImageResource(area.iconRes)
			holder.itemView.setOnClickListener { onAreaClick(area) }
			holder.itemView.setOnLongClickListener {
				onAreaHold(area)
				true
			}
			holder.configAttentionLevelView(area)
			holder.setTint(area.color)
		}
	}
	
	override fun getItemCount() = areas.size
	
	@Suppress("SetTextI18n")
	private fun AreaListItemViewHolder.configAttentionLevelView(area: Area) =
		if (showsPercentage) {
			attentionLevelProgressBar.visibility = View.GONE
			attentionLevelProgressTextView.visibility = View.VISIBLE
			attentionLevelProgressTextView.text = "${area.attentionLevel}%"
			attentionLevelProgressTextView.setTextColor(area.color)
		} else {
			attentionLevelProgressTextView.visibility = View.GONE
			attentionLevelProgressBar.setProgressWithAnimation(area.attentionLevel.toFloat())
		}
}