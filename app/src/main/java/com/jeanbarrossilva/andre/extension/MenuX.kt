package com.jeanbarrossilva.andre.extension

import android.graphics.drawable.Drawable
import android.view.Menu
import androidx.core.view.children

object MenuX {
	fun Menu.add(
		title: CharSequence,
		icon: Drawable,
		order: Int = children.count(),
		groupId: Int = 0,
		id: Int = order
	) {
		add(groupId, id, order, title)
		children.find { item -> item.itemId == id }?.icon = icon
	}
}