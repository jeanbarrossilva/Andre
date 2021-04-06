package com.jeanbarrossilva.andre.ui.layoutmanager

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

class UnscrollableLayoutManager(context: Context?): LinearLayoutManager(context) {
	override fun canScrollHorizontally() = false
	
	override fun canScrollVertically() = false
}