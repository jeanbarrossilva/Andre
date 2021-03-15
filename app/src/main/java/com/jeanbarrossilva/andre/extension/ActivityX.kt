package com.jeanbarrossilva.andre.extension

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.andre.extension.ViewGroupX.find

object ActivityX {
    private val Activity.content
        get() = window?.decorView?.findViewById<FrameLayout>(android.R.id.content)
    
    val Activity.bottomNavigationView get() = find<BottomNavigationView>()
    val Activity.fab get() = find<FloatingActionButton>()
    val Activity.fragmentContainerView get() = find<FragmentContainerView>()
    val Activity.toolbar get() = find<Toolbar>()
    val Activity.view get() = content?.children?.first() as? ViewGroup
    
    private inline fun <reified V : View> Activity.find() = view?.find<V>()
    
    fun Activity.composeEmail(
        receiver: String = "",
        subject: String = "",
        body: String = ""
    ) {
        val emailIntent =
            Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_EMAIL, receiver)
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }
        val emailAppChooserIntent = Intent.createChooser(emailIntent, null)
        
        startActivity(emailAppChooserIntent)
    }
}