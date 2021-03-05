package com.jeanbarrossilva.andre.extension

import androidx.cardview.widget.CardView

object CardViewX {
	fun CardView.setContentPadding(size: Int) =
		setContentPadding(size, size, size, size)
}