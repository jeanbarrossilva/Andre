package com.jeanbarrossilva.andre.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.andre.extension.ActivityX.fab
import com.jeanbarrossilva.andre.extension.AppCompatActivityX.currentFragment

object FragmentX {
    val Fragment.isCurrent get() = (activity as? AppCompatActivity)?.currentFragment == this
    
    fun Fragment.withFab(block: FloatingActionButton.() -> Unit) {
        activity?.fab?.let { block(it) }
    }
}
