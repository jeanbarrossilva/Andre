package com.jeanbarrossilva.andre.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jeanbarrossilva.andre.extension.MaterialDialogX.showSendFeedbackErrorDialog
import com.jeanbarrossilva.andre.extension.ViewGroupX.find

object ActivityX {
    private val Activity.content
        get() = window?.decorView?.findViewById<FrameLayout>(android.R.id.content)
    
    val Activity.fab get() = find<FloatingActionButton>()
    val Activity.toolbar get() = find<Toolbar>()
    val Activity.view get() = content?.children?.first() as? ViewGroup
    
    @SuppressLint("QueryPermissionsNeeded")
    private fun Activity.canStart(intent: Intent) = intent.resolveActivity(packageManager) != null
    
    private inline fun <reified V : View> Activity.find() = view?.find<V>()
    
    fun Activity.composeEmail(
        receiver: String = "",
        subject: String = "",
        body: String = ""
    ) = Intent(Intent.ACTION_SENDTO)
        .apply {
            type = "text/plain"
            data = Uri.parse(receiver)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        .let { if (canStart(it)) startActivity(it) else showSendFeedbackErrorDialog(this) }
}