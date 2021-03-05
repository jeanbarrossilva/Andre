package com.jeanbarrossilva.andre.adapter.viewholder

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.andre.databinding.ViewAreaListItemBinding

class AreaListItemViewHolder(binding: ViewAreaListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val iconView = binding.iconView
    val nameView = binding.nameView
    val attentionLevelProgressBar = binding.attentionLevelProgressBar
    val attentionLevelProgressTextView = binding.attentionLevelProgressTextView

    fun setTint(@ColorInt color: Int) {
        iconView.imageTintList = ColorStateList.valueOf(color)
        attentionLevelProgressBar.progressBarColor = color
        attentionLevelProgressBar.backgroundProgressBarColor = Color.TRANSPARENT
        nameView.setTextColor(color)
        attentionLevelProgressTextView.setTextColor(color)
    }
}