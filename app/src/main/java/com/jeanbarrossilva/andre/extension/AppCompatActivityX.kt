package com.jeanbarrossilva.andre.extension

import androidx.appcompat.app.AppCompatActivity

object AppCompatActivityX {
	val AppCompatActivity.currentFragment
		get() =
			with(supportFragmentManager) {
				primaryNavigationFragment?.childFragmentManager?.fragments?.lastOrNull()
					?: fragments.lastOrNull()
			}
}