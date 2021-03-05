package com.jeanbarrossilva.andre.extension

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.MenuRes
import androidx.core.view.children

object MenuInflaterX {
	fun MenuInflater.inflate(menu: Menu, @MenuRes menuRes: Int, onSelectItem: (MenuItem) -> Unit) {
		inflate(menuRes, menu)
		menu.children.forEach { item ->
			item.setOnMenuItemClickListener {
				onSelectItem(it)
				true
			}
		}
	}
}